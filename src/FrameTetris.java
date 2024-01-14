import javax.swing.*;
import java.awt.event.*;

public class FrameTetris extends JFrame implements KeyListener
{
	private ControleurGUI ctrl;

	private PanelStock    pnlStock;
	private PanelScore    pnlScore;
	private PanelGrille   pnlGrille;
	private PanelSuivants pnlSuivants;

	public FrameTetris( ControleurGUI ctrl )
	{
		this.ctrl = ctrl;

		this.setSize ( 500, 1000 );
		this.setTitle( "Test Tétris" );

		//Création des composants
		//this.pnlStock    = new PanelStock();
		//this.pnlScore    = new PanelScore();
		this.pnlGrille   = new PanelGrille( this.ctrl );
		//this.pnlSuivants = new PanelSuivants();

		// Positionnement des composants
		//this.add ( this.pnlStock );
		//this.add ( this.pnlScore );
		this.add ( this.pnlGrille );
		//this.add ( this.pnlSuivants );

		// Activation des composants
		this.addKeyListener( this );
		this.setVisible ( true );

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

	public void majGrille()
	{
		this.pnlGrille.majGrille();
	}

	@Override
	public void keyPressed( KeyEvent e )
	{
		switch ( e.getKeyCode() )
		{
			case KeyEvent.VK_UP:
			// Fait pivoter la pièce actuelle
			this.ctrl.pivoterPiece();
			// Redessine la grille dans l'interface graphique
			this.majGrille();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}
