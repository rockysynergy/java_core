import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap<Integer,String> hm =new  LinkedHashMap<Integer,String>();
		hm.put(1, null); 
		hm.put(null, "abc");  
		hm.put(1000, "aaa");
		hm.put(2, "bbb");
		hm.put(30000, "ccc");
		System.out.println(hm.containsValue("aaa"));
		System.out.println(hm.containsKey(30000));
		System.out.println(hm.get(30000));
		
		hm.put(30000, "ddd");  //���¸���ccc
		System.out.println(hm.get(30000));
		
		hm.remove(2);
		System.out.println("size: " + hm.size());
		
		//hm.clear();
		//System.out.println("size: " + hm.size());
		
		System.out.println("������ʼ==================");
		
		Integer key;
		String value;
		Iterator<Entry<Integer, String>> iter = hm.entrySet().iterator();
		while(iter.hasNext()) {
		    Map.Entry<Integer, String> entry = iter.next();
		    // ��ȡkey
		    key = entry.getKey();
		    // ��ȡvalue
		    value = entry.getValue();
		    System.out.println("Key:" + key + ", Value:" + value);
		}
		System.out.println("��������==================");		
		
		LinkedHashMap<Integer,String> hm2 =new  LinkedHashMap<Integer,String>();
		for(int i=0;i<100000;i++)
		{
			hm2.put(i, "aaa");
		}
		traverseByEntry(hm2);
		traverseByKeySet(hm2);		
	}
	
	public static void traverseByEntry(LinkedHashMap<Integer,String> ht)
	{
		long startTime = System.nanoTime();
		System.out.println("============Entry����������==============");
		Integer key;
		String value;
		Iterator<Entry<Integer, String>> iter = ht.entrySet().iterator();
		while(iter.hasNext()) {
		    Map.Entry<Integer, String> entry = iter.next();
		    // ��ȡkey
		    key = entry.getKey();
		    // ��ȡvalue
		    value = entry.getValue();
		    //System.out.println("Key:" + key + ", Value:" + value);
		}
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "����");
	}
	
	
	public static void traverseByKeySet(LinkedHashMap<Integer,String> ht)
	{
		long startTime = System.nanoTime();
		System.out.println("============KeySet����������=============="); 
		Integer key;
		String value;
		Iterator<Integer> iter = ht.keySet().iterator();
		while(iter.hasNext()) {
		    key = iter.next();		    
		    // ��ȡvalue
		    value = ht.get(key);
		    //System.out.println("Key:" + key + ", Value:" + value);
		}
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "����");
	}
}
