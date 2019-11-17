package ArryList_Study;

public class Arraylist1 <E> {

	private	Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	
	public Arraylist1() {
		elementData=new Object [DEFALT_CAPACITY];
	}
	
	public Arraylist1(int capacity) {
		
		elementData=new Object[capacity];
	}
	
	public void add(E obj) {
		if(size==elementData.length)
		{
			Object []NewArray=new Object[elementData.length+(elementData.length>>1)];
			System.arraycopy(elementData, 0, NewArray, 0, elementData.length);
			elementData=NewArray;
		}
		elementData[size++]=obj;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i =0;i<size;i++) {
			sb.append(elementData[i]);
			sb.append(",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public E get(int index) {
		return (E)elementData[index];
	}
	
	public void set(E element,int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException();
		}
		elementData[index]=element;	
	}
	
	public void erase(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException();
		}
		
		for (int i=index;i<elementData.length-1;i++)
		{
			elementData[i]=elementData[i+1];
		}
		
	}
	
	public void remove(E element) {
		for(int i=0;i<size;i++) {
			if(element.equals(elementData[i]))
				erase(i);
		}
	}
	
	public boolean isEmpty() {
		return size==0? true:false;
	}
	public static void main(String[] args) {
		
	}
	
}
