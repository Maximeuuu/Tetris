import java.util.Arrays;

public class Tetromino
{
	private static final char[] LST_TETROMINOS = new char[]{'I','O','T','L','J','Z','S'};

	private char[][] matrice;
	private int posX;
	private int posY;

	public Tetromino( Tetromino t )
	{
		this.matrice = t.matrice;
		this.posX    = t.posX;
		this.posY    = t.posY;
	}

	public Tetromino( int posX, int posY )
	{
		char type = Tetromino.LST_TETROMINOS[ (int)( Math.random() * Tetromino.LST_TETROMINOS.length ) ];
		this.matrice = Tetromino.initTetromino( type );
		this.posX    = posX;
		this.posY    = posY;
	}

	public Tetromino( char type )
	{
		this( type, 0, 5 );
	}

	public Tetromino( char type, int posX, int posY )
	{
		this.matrice = Tetromino.initTetromino( type );
		this.posX    = posX;
		this.posY    = posY;
	}

	public int getPosX()
	{
		return this.posX;
	}

	public int getPosY()
	{
		return this.posY;
	}

	public char[][] getMatrice()
	{
		return this.matrice;
	}

	public int getTaille()
	{
		return this.matrice.length;
	}

	public void descendrePosX()
	{
		this.posX++;
	}

	/**source :  https://www.techiedelight.com/fr/place-rotate-matrix-90-degrees-clock-wise-direction/*/
	public void rotate()
	{
		// cas de base
		if (this.matrice == null || this.matrice.length == 0) {
			return;
		}

		// Matrice `N × N`
		int N = this.matrice.length;

		// Transpose la matrice
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < i; j++)
			{
				char temp = this.matrice[i][j];
				this.matrice[i][j] = this.matrice[j][i];
				this.matrice[j][i] = temp;
			}
		}

		// permute les colonnes
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N / 2; j++)
			{
				char temp = this.matrice[i][j];
				this.matrice[i][j] = this.matrice[i][N - j - 1];
				this.matrice[i][N - j - 1] = temp;
			}
		}
	}

	public String toString()
	{
		String s="";
		for( int cptLig = 0; cptLig < this.matrice.length; cptLig++ )
		{
			for( int cptCol = 0; cptCol < this.matrice[cptLig].length; cptCol++ )
			{
				if( this.matrice[cptLig][cptCol] == ' ' )
				{
					s+=".";
				}
				else
				{
					s+="#";
				}
			}
			s+="\n";
		}
		return s;
	}

	public static String getCouleur( char type )
	{
		if( type == 'I' ){ return "#2bace2"; }
		if( type == 'O' ){ return "#fde100"; }
		if( type == 'T' ){ return "#922b8c"; }
		if( type == 'L' ){ return "#f89622"; }
		if( type == 'J' ){ return "#005a9d"; }
		if( type == 'Z' ){ return "#ee2733"; }
		if( type == 'S' ){ return "#4eb748"; }

		return "#eeeeee";
	}

	private static char[][] initTetromino( char type )
	{
		if( type == 'I' )
		{
			return	new char[][]
					{
					{' ',' ','I',' '},
					{' ',' ','I',' '},
					{' ',' ','I',' '},
					{' ',' ','I',' '}
					};
		}

		if( type == 'O' )
		{
			return	new char[][]
					{
					{'O','O'},
					{'O','O'},
					};
		}

		if( type == 'T' )
		{
			return	new char[][]
					{
					{'T','T','T'},
					{' ','T',' '},
					{' ',' ',' '}
					};
		}

		if( type == 'L' )
		{
			return	new char[][]
					{
					{' ',' ','L'},
					{'L','L','L'},
					{' ',' ',' '}
					};
		}

		if( type == 'J' )
		{
			return	new char[][]
					{
					{'J',' ',' '},
					{'J','J','J'},
					{' ',' ',' '}
					};
		}

		if( type == 'Z' )
		{
			return	new char[][]
					{
					{'Z','Z',' '},
					{' ','Z','Z'},
					{' ',' ',' '}
					};
		}

		if( type == 'S' )
		{
			return	new char[][]
					{
					{' ','S','S'},
					{'S','S',' '},
					{' ',' ',' '}
					};
		}

		return null;
	}
}
