import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 * A {@link JPanel} which is used in the {@link NBADatabaseUI} program.
 * Serves the purpose of allowing information/statistics to be displayed about a
 * specific {@link NBAPlayer}.
 * 
 * @author Matt Conforti
 */
public class PlayerPanel extends JPanel
{
	/** The {@link NBAPlayer} object for which this panel is being displayed for. */
	private NBAPlayer player;
	
	/** A {@link JLabel} which holds an image of the {@link NBAPlayer} for whom this panel is for. */
	private final JLabel playerImage;
	
	/** A {@link JTextField} which acts as a label to display the text 'Name: '. */
	private final JTextField nameLabel;
	
	/** A {@link JTextField} which displays the {@link NBAPlayer}'s name. */
	private JTextField nameField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Number: '. */
	private final JTextField numberLabel;
	
	/** A {@link JTextField} which displays the {@link NBAPlayer}'s jersey number. */
	private JTextField numberField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Position: '. */
	private final JTextField positionLabel;
	
	/** A {@link JTextField} which displays the {@link NBAPlayer}'s position. */
	private JTextField positionField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Team: '. */
	private final JTextField teamLabel;
	
	/** A {@link JTextField} which displays the {@link NBAPlayer}'s current team. */
	private JTextField teamField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Height: '. */
	private final JTextField heightLabel;
	
	/** A {@link JTextField} which displays the {@link NBAPlayer}'s height. */
	private JTextField heightField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Weight: '. */
	private final JTextField weightLabel;
	
	/** A {@link JTextField} which displays the {@link NBAPlayer}'s weight. */
	private JTextField weightField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Age: '. */
	private final JTextField ageLabel;
	
	/** A {@link JTextField} which displays the {@link NBAPlayer}'s age. */
	private JTextField ageField;
	
	/** A {@link JButton} which enables the user to display the {@link NBAPlayer}'s statistics for the current season. */
	private JButton seasonStats;
	
	/** A {@link JButton} which enables the user to display the {@link NBAPlayer}'s career statistics. */
	private JButton careerStats;
	
	/**
	 * Creates a new instance of {@link PlayerPanel}.
	 * 
	 * @param playerName The name of the player for which the information will be displayed.
	 */
	public PlayerPanel( String playerName )
	{
		super( new GridBagLayout() );
		
		this.player = NBADatabase.playerMap.get( playerName );
				
	// Player Image
	// -------------------------------------------------------------
		
		if( player.getImagePath().equals( "" ) )  // if the player does not have a profile picture
		{
			ImageIcon pImage = new ImageIcon( "/Users/mattconforti/Desktop/Java/workspace/NBAProject/default_profile_picture.png" );
			ImageIcon resizedPImage = new ImageIcon( pImage.getImage().getScaledInstance( 225, 200, Image.SCALE_SMOOTH ) );
			this.playerImage = new JLabel( resizedPImage );
		}
		else  // otherwise
		{
			ImageIcon pImage = new ImageIcon( player.getImagePath() );
			ImageIcon resizedPImage = new ImageIcon( pImage.getImage().getScaledInstance( 270, 200, Image.SCALE_SMOOTH ) );
			this.playerImage = new JLabel( resizedPImage );
		}
		
		this.add( playerImage,
				new GridBagConstraints( 0, 0,
						1, 0,
						1.0, 1.0, 
						GridBagConstraints.NORTHWEST,
						GridBagConstraints.NONE,
						new Insets( 10, 10, 5, 5 ), 0, 0 ) );
		
	// Name Label & Field
	// -------------------------------------------------------------
				
		this.nameLabel = new JTextField( " Name:     " );
		nameLabel.setEnabled( true );
		nameLabel.setEditable( false );
		nameLabel.setBackground( new JLabel().getBackground() );
		nameLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( nameLabel,
				new GridBagConstraints( 1, 0,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 15, 5, 5, 15 ), 0, 0 ) );
		
		this.nameField = new JTextField( " " + player.getName() , 15 );
		nameField.setEnabled( true );
		nameField.setEditable( false );
		nameField.setBackground( new JLabel().getBackground() );
		nameField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( nameField,
				new GridBagConstraints( 2, 0,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 15, 5, 5, 30 ), 0, 0 ) );
		
	// Number Label & Field
	// -------------------------------------------------------------
		
		this.numberLabel = new JTextField( " Number: " );
		numberLabel.setEnabled( true );
		numberLabel.setEditable( false );
		numberLabel.setBackground( new JLabel().getBackground() );
		numberLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( numberLabel,
				new GridBagConstraints( 1, 1,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
		
		this.numberField = new JTextField( " " + Integer.toString( player.getJerseyNum() ) , 15 );
		numberField.setEnabled( true );
		numberField.setEditable( false );
		numberField.setBackground( new JLabel().getBackground() );
		numberField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( numberField,
				new GridBagConstraints( 2, 1,
						1, 1, 
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 30 ), 0, 0 ) );
	
	// Position Label & Field
	// -------------------------------------------------------------
		
		this.positionLabel = new JTextField( " Position: " );
		positionLabel.setEnabled( true );
		positionLabel.setEditable( false );
		positionLabel.setBackground( new JLabel().getBackground() );
		positionLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		 
		this.add( positionLabel,
				new GridBagConstraints( 1, 2,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
		
		positionField = new JTextField( " " + player.getPosition(), 15 );
		positionField.setEnabled( true );
		positionField.setEditable( false );
		positionField.setBackground( new JLabel().getBackground() );
		positionField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( positionField,
				new GridBagConstraints( 2, 2,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 30 ), 0, 0 ) );
		
	// Team Label & Field
	// -------------------------------------------------------------	
		
		this.teamLabel = new JTextField( " Team:     " );
		teamLabel.setEnabled( true );
		teamLabel.setEditable( false );
		teamLabel.setBackground( new JLabel().getBackground() );
		teamLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( teamLabel,
				new GridBagConstraints( 1, 3,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
		
		this.teamField = new JTextField( " " + player.getTeam(), 15 );
		teamField.setEnabled( true );
		teamField.setEditable( false );
		teamField.setBackground( new JLabel().getBackground() );
		teamField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( teamField,
				new GridBagConstraints( 2, 3, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 30 ), 0, 0 ) );
		
	// Height Label & Field
	// -------------------------------------------------------------
		
		this.heightLabel = new JTextField( " Height:   " );
		heightLabel.setEnabled( true );
		heightLabel.setEditable( false );
		heightLabel.setBackground( new JLabel().getBackground() );
		heightLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( heightLabel,
				new GridBagConstraints( 1, 4,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
		
		this.heightField = new JTextField( " " + player.getHeight(), 15 );
		heightField.setEnabled( true );
		heightField.setEditable( false );
		heightField.setBackground( new JLabel().getBackground() );
		heightField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( heightField,
				new GridBagConstraints( 2, 4, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 30 ), 0, 0 ) );
		
	// Weight Label & Field
	// -------------------------------------------------------------
		
		this.weightLabel = new JTextField( " Weight:   " );
		weightLabel.setEnabled( true );
		weightLabel.setEditable( false );
		weightLabel.setBackground( new JLabel().getBackground() );
		weightLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( weightLabel,
				new GridBagConstraints( 1, 5,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
		
		this.weightField = new JTextField( " " + Integer.toString( player.getWeight() ) + " lbs", 15 );
		weightField.setEnabled( true );
		weightField.setEditable( false );
		weightField.setBackground( new JLabel().getBackground() );
		weightField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( weightField,
				new GridBagConstraints( 2, 5, 
						1, 1, 
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 30 ), 0, 0 ) );
		
	// Age Label & Field
	// -------------------------------------------------------------
		
		this.ageLabel = new JTextField( " Age:        " );
		ageLabel.setEnabled( true );
		ageLabel.setEditable( false );
		ageLabel.setBackground( new JLabel().getBackground() );
		ageLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( ageLabel,
				new GridBagConstraints( 1, 6, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
		
		this.ageField = new JTextField( " " + Integer.toString( player.getAge() ), 15 );
		ageField.setEnabled( true );
		ageField.setEditable( false );
		ageField.setBackground( new JLabel().getBackground() );
		ageField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( ageField,
				new GridBagConstraints( 2, 6,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 30 ), 0, 0 ) );
	
	// Season Stats Button
	// -------------------------------------------------------------
		
		this.seasonStats = new JButton( "Season Stats" );
		
		this.add( seasonStats,
				new GridBagConstraints( 0, 7, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.CENTER, 
						GridBagConstraints.NONE,
						new Insets( 5, 25, 5, 5 ), 0, 0 ) );
		
		seasonStats.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{	
						JOptionPane.showMessageDialog( null, "2017-2018 Season"
								+ "\n----------------"
								+ "\nMPG" + "  |"
								+ "\nPPG" + "  |"
								+ "\nRPG" + "  |"
								+ "\nAPG" + "  |"
								,"Season Statistics", JOptionPane.INFORMATION_MESSAGE );
					}
				} );
		
	// Career Stats Button
	// -------------------------------------------------------------
		
		this.careerStats = new JButton( "Career Stats" );
		
		this.add( careerStats,
				new GridBagConstraints( 2, 7,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.WEST,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 25 ), 0, 0 ) );
		
	// -------------------------------------------------------------
		
	}
}
