import java.awt.Color;

public class Grille
{
	//private Bloc[][] tabBloc;
	private char[][] tabBloc;
	private Tetromino tetrominoActuel;
	private Tetromino tetrominoPrecedent;

	public Grille( int largeur, int hauteur )
	{
		this.tabBloc = new char[largeur][hauteur];
		this.initGrille();
		this.addNewTetromino();
		this.tetrominoPrecedent = this.tetrominoActuel;
		/*this.tabBloc[2][3] = new Bloc( new Color(0,0,255) );
		this.tabBloc[2][4] = new Bloc( new Color(0,0,255) );
		this.tabBloc[2][5] = new Bloc( new Color(0,0,255) );
		this.tabBloc[3][4] = new Bloc( new Color(0,0,255) );*/
	}

	public void fusionnerPieceGrille()
	{
		this.tetrominoPrecedent = null;
		int x = this.tetrominoActuel.getPosX();
		int y = this.tetrominoActuel.getPosY();
		int taille = this.tetrominoActuel.getTaille();

		for( int cptLig = 0; cptLig < taille; cptLig++ )
		{
			for( int cptCol = 0; cptCol < taille; cptCol++ )
			{
				if( this.tetrominoActuel.getMatrice()[cptLig][cptCol] != ' ' )
				{
					this.tabBloc[ x + cptLig-taille/2 ][ y + cptCol-taille/2 ] = this.tetrominoActuel.getMatrice()[cptLig][cptCol];
				}
			}
		}
	}

	public boolean addNewTetromino()
	{
		//if peut pas -> false
		Tetromino t = new Tetromino( 3, 3 ); // Créer une nouvelle pièce
		this.tetrominoActuel = t;
		this.addTetromino(t); // Ajouter la nouvelle pièce à la grille
		return true;
	}

	public void addTetromino( Tetromino t )
	{
		int x = t.getPosX();
		int y = t.getPosY();
		int taille = t.getTaille();

		for( int cptLig = 0; cptLig < taille; cptLig++ )
		{
			for( int cptCol = 0; cptCol < taille; cptCol++ )
			{
				if( this.tabBloc[ x + cptLig-taille/2 ][ y + cptCol-taille/2 ] == ' ' )
				{
					this.tabBloc[ x + cptLig-taille/2 ][ y + cptCol-taille/2 ] = t.getMatrice()[cptLig][cptCol];
				}
			}
		}
	}

	public void removeTetromino( Tetromino t )
	{
		if( t == null ){ return; }
		int x = t.getPosX();
		int y = t.getPosY();
		int taille = t.getTaille();

		for( int cptLig = 0; cptLig < taille; cptLig++ )
		{
			for( int cptCol = 0; cptCol < taille; cptCol++ )
			{
				if( this.tabBloc[ x + cptLig-taille/2 ][ y + cptCol-taille/2 ] != ' ' )
				{
					this.tabBloc[ x + cptLig-taille/2 ][ y + cptCol-taille/2 ] = ' ';
				}
			}
		}
	}

	public void descendreTetromino()
	{
		this.removeTetromino( this.tetrominoPrecedent );

		this.tetrominoPrecedent = new Tetromino( this.tetrominoActuel );

		this.tetrominoActuel.descendrePosX();
		this.addTetromino( this.tetrominoActuel );
	}

	public boolean peutAvancerPiece()
	{
		if( this.tetrominoActuel == null ){ return false; }
		/*if( this.tetrominoActuel.getPosX() >= this.getLargeur()-1 || this.tetrominoActuel.getPosX() < 0 ){ return false; }
		if( this.tetrominoActuel.getPosY() >= this.getHauteur()-1 || this.tetrominoActuel.getPosY() < 0 ){ return false; }*/

		int x = tetrominoActuel.getPosX();
		int y = tetrominoActuel.getPosY()+1;
		int taille = tetrominoActuel.getTaille();

		for( int cptLig = 0; cptLig < taille; cptLig++ )
		{
			for( int cptCol = 0; cptCol < taille; cptCol++ )
			{
				if(  this.tetrominoActuel.getMatrice()[cptLig][cptCol] != ' ' )
				{
					if( x + cptLig-taille/2 <0 ){ return false; }
					if( x + cptLig-taille/2 >= this.getLargeur()-1 ){ return false; }
					if( y + cptCol-taille/2 <0 ){ return false; }
					if( y + cptCol-taille/2 >= this.getHauteur()-1 ){ return false; }
					/*if( this.tabBloc[ x + cptLig-taille/2 ][ y + cptCol-taille/2 ] != ' ' ){ return false; }*/ // il se test sur lui même et se bloque
				}
			}
		}
		return true;
	}

	public void pivoterPiece()
	{
		this.tetrominoActuel.rotate();
	}

	public char getBloc( int x, int y )
	{
		return this.tabBloc[x][y];
	}

	public int getLargeur()
	{
		return this.tabBloc.length;
	}

	public int getHauteur()
	{
		return this.tabBloc[0].length;
	}

	private void initGrille()
	{
		for( int cptLig = 0; cptLig < this.tabBloc.length; cptLig++ )
		{
			for( int cptCol = 0; cptCol < this.tabBloc[cptLig].length; cptCol++ )
			{
				this.tabBloc[cptLig][cptCol] = ' ';
			}
		}
	}
}
