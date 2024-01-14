public class TestTetromino
{
	public static void main( String[] args )
	{
		Tetromino t1 = new Tetromino('Z');
		System.out.println(t1.toString());;
		
		t1.rotate();
		System.out.println(t1.toString());
		
		t1.rotate();
		t1.rotate();
		System.out.println(t1.toString());
	}
}
