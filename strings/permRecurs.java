package permRecurs;

public class permRecurs {

	public void permFunc(char[] arry, int k, int size){
		if(k==size){
			for(int i=0;i<arry.length;i++){
				System.out.print(arry[i]);
			}
				System.out.print(" ");
		}else{
			char t;
			for(int i=k;i<size;i++){
				t=arry[i]; arry[i]= arry[k]; arry[k]=t;
				permFunc(arry,k+1,size);
				t=arry[i]; arry[i]= arry[k]; arry[k]=t;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		char[] chArry = str.toCharArray();
		permRecurs pr = new permRecurs();
		pr.permFunc(chArry, 0, chArry.length);
	}
}
