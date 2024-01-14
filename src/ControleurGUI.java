import java.awt.Color;
import java.lang.Thread;

public class ControleurGUI
{
	private Grille grille;
	private FrameTetris ihm;

	public ControleurGUI()
	{
		this.grille = new Grille(20,8);
		this.ihm = new FrameTetris( this );


		// Initialise le thread qui gère la chute automatique
		while (true)
		{
			try
			{
				Thread.sleep(1000); // Attend 1 seconde

				if ( !this.grille.peutAvancerPiece() )
				{
					// Si la pièce ne peut plus descendre, en ajouter une nouvelle
					this.grille.fusionnerPieceGrille();
					this.grille.addNewTetromino();
				}
				else
				{
					this.grille.descendreTetromino();
				}
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			this.ihm.majGrille();
		}
	}

	public static void main( String[] args )
	{
		new ControleurGUI();
	}

	/*
	public void avancerPiece()
	{
		// Vérifie si la pièce actuelle peut avancer d'une ligne
		if ( this.grille.peutAvancerPiece())
		{
			// Déplace la pièce actuelle d'une ligne vers le bas
			this.grille.avancerPiece();
			// Redessine la grille dans l'interface graphique
			this.ihm.redessinerGrille();
		}
		else
		{
			// La pièce actuelle ne peut plus avancer, on la fige dans la grille
			this.grille.figerPiece();
			// On crée une nouvelle pièce aléatoire
			Tetromino t = Tetromino.creerPieceAleatoire();
			this.grille.addTetromino(t);
			// On redessine la grille dans l'interface graphique
			this.ihm.redessinerGrille();
		}
	}*/
	public void pivoterPiece()
	{
		this.grille.pivoterPiece();
	}

	public Color getCouleurBloc( int x, int y )
	{
		return Color.decode( Tetromino.getCouleur( this.grille.getBloc(x, y) ) );
	}

	public int getHauteurGrille()
	{
		return this.grille.getHauteur();
	}

	public int getLargeurGrille()
	{
		return this.grille.getLargeur();
	}
}
