package com.techm.cache.main;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * Manages Caching.Default SIZE is 10
 * @author Niks
 *
 */
public class CacheManager implements Cloneable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Class, LinkedHashMap<Long, Object>> cacheMap=new ConcurrentHashMap<Class,LinkedHashMap<Long,Object>>();
	
	private final static int CACHE_SIZE=10;
	
	private static volatile CacheManager instance=new CacheManager();
	
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private CacheManager(){
	}
	
	protected Object readResolve() throws ObjectStreamException{
		return instance;
	}
	
	@Override
	protected Object clone(){
		throw new RuntimeException("Clone Not Supported fr Singleton.");
	}
	
	/**
	 * Singleton Cache Obj.
	 * @return
	 */
	public static CacheManager getInstance(){
		return instance;
	}
	/**
	 * Add new records to cache.
	 * @param id
	 * @param obj
	 * @return
	 */
	public Object addToCache(Long id,Object obj)
	{
		LinkedHashMap<Long,Object> map = cacheMap.get(obj.getClass());
		if(null==map){
			map=new LinkedHashMap<Long,Object>(){

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
		        protected boolean removeEldestEntry(final Map.Entry eldest) {
		            return size() > CACHE_SIZE;
		        }
			};
		}
		Object addedObj=null;
		readWriteLock.writeLock().lock();
		try{
			addedObj=map.putIfAbsent(id, obj);
			cacheMap.put(obj.getClass(),map);
		}
		finally{
			readWriteLock.writeLock().unlock();
		}
		return addedObj;
	}
	
	
	/**
	 * Manually Remove objects from Cache.
	 * @param id
	 * @param obj
	 * @return
	 */
	public Object removeFromCache(Long id,Object obj){
		Map<Long,Object> map = cacheMap.get(obj.getClass());
		if(null!=map){
			return map.remove(id);
		}
		return null;
	}
	
	/**
	 * Empties whole cache.
	 */
	public void cleanCache(){
		cacheMap.clear();
	}
	
	
	/**
	 * If object data contains in cache.
	 * @param id
	 * @return
	 */
	public boolean existInCache(Long id,Class classType){
		Map<Long,Object> map = cacheMap.get(classType);
		if(map!=null&& map.containsKey(id)){
			return true;
		}
		return false;
	}
	
	/**
	 * Gets Cached Object.
	 * @param id
	 * @param classType
	 * @return
	 */
	public Object getCacheObject(Long id,Class classType){
		readWriteLock.readLock().lock();
		Map<Long,Object> map =cacheMap.get(classType);;
		Object obj=null;
		try{

			obj=map.get(id);
		}
		finally{
			readWriteLock.readLock().unlock();
		}
		return obj;
	}
}
