import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;

public class PanelGrille extends JPanel
{
	private ControleurGUI ctrl;
	private JLabel[][]    tabLblCase;

	public PanelGrille( ControleurGUI ctrl )
	{
		this.ctrl = ctrl;
		this.setLayout( new GridLayout(ctrl.getLargeurGrille(),ctrl.getHauteurGrille()) );

		int l = this.ctrl.getLargeurGrille();
		int h = this.ctrl.getHauteurGrille();
		this.tabLblCase = new JLabel[l][h];

		for( int cptLig = 0; cptLig < l-1; cptLig++ )
		{
			for( int cptCol = 0; cptCol < h-1; cptCol++ )
			{
				this.tabLblCase[cptLig][cptCol] = new JLabel( "_" );
				this.tabLblCase[cptLig][cptCol].setOpaque(true);
				this.tabLblCase[cptLig][cptCol].setBackground( this.ctrl.getCouleurBloc(cptLig, cptCol) );
				this.add( this.tabLblCase[cptLig][cptCol] );
			}
		}

		this.majGrille();
		this.setVisible(true);
	}

	public void majGrille()
	{
		int l = this.ctrl.getLargeurGrille();
		int h = this.ctrl.getHauteurGrille();

		for( int cptLig = 0; cptLig < l-1; cptLig++ )
		{
			for( int cptCol = 0; cptCol < h-1; cptCol++ )
			{
				this.tabLblCase[cptLig][cptCol].setOpaque(true);
				this.tabLblCase[cptLig][cptCol].setBackground( this.ctrl.getCouleurBloc(cptLig, cptCol) );
			}
		}
	}
}
