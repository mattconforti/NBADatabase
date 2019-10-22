import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * A {@link JPanel} that displays information for a specific {@link NBATeam}.
 * 
 * @author Matt Conforti
 */
public class TeamPanel extends JPanel
{
	/** The {@link NBATeam} which we are using this panel to display. */
	private NBATeam teamToDisplay;
	
	/** The {@link JScrollPane} which displays a list of {@link NBAPlayer}s on a specific {@link NBATeam}. */
	private JScrollPane playerList;
	
	/** Creates a new {@link TeamPanel}. */
	public TeamPanel(String teamName)
	{
		super( new GridBagLayout() );
		
	// PlayerField -- ( ScrollPane )
	//---------------------------------------------------------
		this.playerList = new JScrollPane();
	
	// NBATeam
	//---------------------------------------------------------
		this.teamToDisplay = NBADatabase.teamMap.get( teamName );
	}
}
