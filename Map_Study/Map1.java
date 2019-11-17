package Map_Study;
/**
 * ×Ô¶¨ÒåHashMap
 * @author Administrator
 *
 */
public class Map1 {

	Node[] table;
	int size;
	
	public Map1() {
		
 		table=new Node[16];
		
	}
	
	public int MyHash(int y,int length) {
		return y&(length-1);
	}
	
	public void put(Object key,Object obj) {
		
		Node newNode=new Node();
		newNode.hash=MyHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=obj;
		newNode.next=null;
		
		Node temp=table[newNode.hash];
		if(temp==null) {
			table[newNode.hash]=newNode;
		}
		else {
			Node iterLast=null;
			while(temp!=null) {
				if(temp.key.equals(key))
				{
					temp.value=obj;
					return;
				}
				 iterLast=temp;
				temp=temp.next;
				
			}
			iterLast.next=newNode;
			
		}
		size++;
		
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sb=new StringBuilder("{");
			
			for(int i=0;i<table.length;i++) {
				Node temp=table[i];
				while(temp!=null)
				{	sb.append(temp.key+" : "+temp.value+" , ");
					temp=temp.next;
				}
				
			}
			sb.setCharAt((sb.length()-1),' ');
			sb.setCharAt((sb.length()-2),'}');
			
			return sb.toString();
		
		}
	
	public void remove(Object key){
		int hash=MyHash(key.hashCode(),table.length);
		if(table[hash]==null)
			throw new RuntimeException("Not find");
		else if(table[hash].next==null) {
			table[hash]=null;
		}
		else {
			Node temp=table[hash];
			Node save=temp;
			while(temp.next!=null) {
				
				if(key.equals(temp.key)) {
					save.next=temp.next;
					return;
				}
				save=temp;
				temp=temp.next;
				
			}
			
		}
		
	}
	
	public Object get(Object key) {
		
		int hash=MyHash(key.hashCode(),table.length);
		Object value=null;
		if(table[hash]==null)
			return value;
		else {
			Node temp=table[hash];
			while(temp!=null) {
				if(temp.key==key)
					return temp.value;
				
			}
			
			return value;
			
		}
		
	}
	
	
	public static void main(String args[]) {
		Map1 m=new Map1();
		m.put("aaa", "a");
		m.put("bbb", "b");
		m.put("ccc", "c");
		m.remove("bbb");
		System.out.println(m);
		System.out.println("Finish");
	}
	
}

