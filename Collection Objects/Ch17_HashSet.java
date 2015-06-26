import java.util.HashSet;


public class Ch17_HashSet {

	public static void main(String[] args) {
		// 集合物件 HashSet 宣告
		HashSet<String> hset = new HashSet<>();
		String name0 = "江小魚", name1 = "小龍女";
		System.out.println("新增元素前是否是空的=" + hset.isEmpty());
		
		hset.add("陳會安");		// 新增元素
		hset.add(name0);		hset.add("陳允傑");
		// 顯示尺寸和是否是空的
		System.out.println("新增後尺寸=" + hset.size());
		System.out.println("是否是空的=" + hset.isEmpty());
		// 顯示集合物件內容
		System.out.print("HashSet 內容: ");
		System.out.println(hset);
		
		// 是否擁有指定元素
		System.out.println("HashSet 是否有[" + name0 + "]: " + 
				hset.contains(name0));
		System.out.println("HashSet 是否有[" + name1 + "]: " +
				hset.contains(name1));
		
		hset.remove(name0);		// 刪除元素
		System.out.print("HashSet 刪除[" + name0 + "]:");
		System.out.println(hset);
		hset.clear();			// 清除集合物件
	}
}
