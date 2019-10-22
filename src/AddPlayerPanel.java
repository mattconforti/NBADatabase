import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

/**
 * A {@link JPanel} which is used in the {@link NBADatabaseUI} program.
 * Serves the purpose of allowing administrators to add {@link NBAPlayer}s to the database.
 * 
 * @author Matt Conforti
 */
public class AddPlayerPanel extends JPanel 
{
	/** The {@link NBAPlayer} object whom is being added to the database. */
	private NBAPlayer player;
	
	/** A {@link JButton} which allows the user to select an image to be used for the {@link NBAPlayer}. */
	private final JButton imageSelectButton;
	
	/** A {@link JTextField} which displays if an image has been selected or not. */
	private JTextField imageField;
	
	/** A {@link File} object which is selected by the user through the use of the imageSelectButton. */
	private File selectedImage;
	
	/** A {@link JTextField} which acts as a label to display the text 'Name: '. */
	private final JTextField nameLabel;
	
	/** A {@link JTextField} which allows the user to enter the {@link NBAPlayer}'s name. */
	private JTextField nameField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Number: '. */
	private final JTextField numberLabel;
	
	/** A {@link JTextField} which allows the user to enter the {@link NBAPlayer}'s jersey number. */
	private JTextField numberField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Position: '. */
	private final JTextField positionLabel;
	
	/** A {@link JTextField} which allows the user to enter the {@link NBAPlayer}'s position. */
	private JTextField positionField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Team: '. */
	private final JTextField teamLabel;
	
	/** A {@link JTextField} which allows the user to enter the {@link NBAPlayer}'s current team. */
	private JTextField teamField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Height: '. */
	private final JTextField heightLabel;
	
	/** A {@link JTextField} which allows the user to enter the {@link NBAPlayer}'s height. */
	private JTextField heightField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Weight: '. */
	private final JTextField weightLabel;
	
	/** A {@link JTextField} which allows the user to enter the {@link NBAPlayer}'s weight. */
	private JTextField weightField;
	
	/** A {@link JTextField} which acts as a label to display the text 'Age: '. */
	private final JTextField ageLabel;
	
	/** A {@link JTextField} which allows the user to enter the {@link NBAPlayer}'s age. */
	private JTextField ageField;
	
	/** A {@link JButton} which allows the user to finalize the addition of an {@link NBAPlayer} to the database. */
	private final JButton addButton;
	
	/** A boolean value which determines if any of the above fields are left blank by the user. */
	private boolean fieldsBlank;
	
	/** Creates a new instance of {@link AddPlayerPanel}. */
	public AddPlayerPanel()
	{
		super( new GridBagLayout() );
		
		this.player = new NBAPlayer();  // create a new player
		
	// Name Label & Field
	// -------------------------------------------------------------
					
		this.nameLabel = new JTextField( " Name:     " );
		nameLabel.setEnabled( true );
		nameLabel.setEditable( false );
		nameLabel.setBackground( new JLabel().getBackground() );
		nameLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( nameLabel,
				new GridBagConstraints( 0, 0,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 10, 5, 5, 5 ), 0, 0 ) );
			
		this.nameField = new JTextField( " ", 15 );
		nameField.setEnabled( true );
		nameField.setEditable( true );
		nameField.setBackground( new JLabel().getBackground() );
		nameField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( nameField,
				new GridBagConstraints( 1, 0,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 10, 5, 5, 15 ), 0, 0 ) );
			
	// Number Label & Field
	// -------------------------------------------------------------
			
		this.numberLabel = new JTextField( " Number: " );
		numberLabel.setEnabled( true );
		numberLabel.setEditable( false );
		numberLabel.setBackground( new JLabel().getBackground() );
		numberLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( numberLabel,
				new GridBagConstraints( 0, 1,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
		this.numberField = new JTextField( " ", 15 );
		numberField.setEnabled( true );
		numberField.setEditable( true );
		numberField.setBackground( new JLabel().getBackground() );
		numberField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( numberField,
				new GridBagConstraints( 1, 1,
						1, 1, 
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
	
	// Position Label & Field
	// -------------------------------------------------------------
			
		this.positionLabel = new JTextField( " Position: " );
		positionLabel.setEnabled( true );
		positionLabel.setEditable( false );
		positionLabel.setBackground( new JLabel().getBackground() );
		positionLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			 
		this.add( positionLabel,
				new GridBagConstraints( 0, 2,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
		positionField = new JTextField( " ", 15 );
		positionField.setEnabled( true );
		positionField.setEditable( true );
		positionField.setBackground( new JLabel().getBackground() );
		positionField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( positionField,
				new GridBagConstraints( 1, 2,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
			
	// Team Label & Field
	// -------------------------------------------------------------	
			
		this.teamLabel = new JTextField( " Team:     " );
		teamLabel.setEnabled( true );
		teamLabel.setEditable( false );
		teamLabel.setBackground( new JLabel().getBackground() );
		teamLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( teamLabel,
				new GridBagConstraints( 0, 3,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
		this.teamField = new JTextField( " ", 15 );
		teamField.setEnabled( true );
		teamField.setEditable( true );
		teamField.setBackground( new JLabel().getBackground() );
		teamField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( teamField,
				new GridBagConstraints( 1, 3, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
			
	// Height Label & Field
	// -------------------------------------------------------------
			
		this.heightLabel = new JTextField( " Height:   " );
		heightLabel.setEnabled( true );
		heightLabel.setEditable( false );
		heightLabel.setBackground( new JLabel().getBackground() );
		heightLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( heightLabel,
				new GridBagConstraints( 0, 4,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
		this.heightField = new JTextField( " ", 15 );
		heightField.setEnabled( true );
		heightField.setEditable( true );
		heightField.setBackground( new JLabel().getBackground() );
		heightField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( heightField,
				new GridBagConstraints( 1, 4, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
			
	// Weight Label & Field
	// -------------------------------------------------------------
			
		this.weightLabel = new JTextField( " Weight:   " );
		weightLabel.setEnabled( true );
		weightLabel.setEditable( false );
		weightLabel.setBackground( new JLabel().getBackground() );
		weightLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( weightLabel,
				new GridBagConstraints( 0, 5,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
		this.weightField = new JTextField( " ", 15 );
		weightField.setEnabled( true );
		weightField.setEditable( true );
		weightField.setBackground( new JLabel().getBackground() );
		weightField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( weightField,
				new GridBagConstraints( 1, 5, 
						1, 1, 
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
			
	// Age Label & Field
	// -------------------------------------------------------------
			
		this.ageLabel = new JTextField( " Age:        " );
		ageLabel.setEnabled( true );
		ageLabel.setEditable( false );
		ageLabel.setBackground( new JLabel().getBackground() );
		ageLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( ageLabel,
				new GridBagConstraints( 0, 6, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
		this.ageField = new JTextField( " ", 15 );
		ageField.setEnabled( true );
		ageField.setEditable( true );
		ageField.setBackground( new JLabel().getBackground() );
		ageField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
		this.add( ageField,
				new GridBagConstraints( 1, 6,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
	// Player Image	
	// -------------------------------------------------------------
		
		this.imageSelectButton = new JButton( "Select Image" );
		
		this.add( imageSelectButton,
				new GridBagConstraints( 0, 7,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 1, 5, 5, 5 ), 0, 0 ) );
		
		imageSelectButton.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser imageSelector = new JFileChooser();
				imageSelector.setCurrentDirectory( new File( "." ) );   // current directory
				imageSelector.setFileSelectionMode( JFileChooser.FILES_ONLY );
				imageSelector.setDialogTitle( "Select an image: " );
				int imgSelectrRetVal = imageSelector.showDialog( null, "Upload" );   // the imageSelector's return value
				
				if( imgSelectrRetVal == JFileChooser.APPROVE_OPTION )   // if the user selects a file to upload
				{
					try
					{
						selectedImage = imageSelector.getSelectedFile();   // try to save the image
						
						if( ! ( selectedImage.exists() ) )   // if the image does not exist... error
						{
							JOptionPane.showMessageDialog( null, "This image does not exist. Please try again.", "Error",
									JOptionPane.ERROR_MESSAGE );
						}
						else   // if the image exists
						{
							imageField.setText( " Upload Successful" );
							player.setImagePath( selectedImage.getPath() );   // associate this image with the player
						}
					}
					catch( Exception eX)
					{
						JOptionPane.showMessageDialog( null, "The image could not be uploaded. Please try again.", "Error",
								JOptionPane.ERROR_MESSAGE );
					}
				}
			}
		} );
		
		this.imageField = new JTextField( " ", 15 );
		imageField.setEnabled( true );
		imageField.setEditable( false );
		imageField.setBackground( new JLabel().getBackground() );
		imageField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		imageField.setText( " ( not required )" );
		
		this.add( imageField,
				new GridBagConstraints( 1, 7, 
						1, 1,
						0.0, 0.0,
						GridBagConstraints.NORTH,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 15 ), 0, 0 ) );
		
	// Add Button	
	// -------------------------------------------------------------
		
		this.addButton = new JButton( "Add" );
		
		this.add( addButton,
				new GridBagConstraints( 1, 8,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.SOUTHEAST,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
		
		addButton.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{   // if the player is already in the database
						if( NBADatabase.playerMap.containsKey( nameField.getText().trim() ) )
						{
							JOptionPane.showMessageDialog( null, "This player is already in the database!",
									"Error", JOptionPane.ERROR_MESSAGE );
							nameField.setText( " " );
						}
						else
						{   // check to see if any of the fields are empty.. if not.. continue
							AddPlayerPanel.this.fieldsBlank = ( ( nameField.getText().equals( " " ) ) || 
							( numberField.getText().equals( " " ) ) || ( positionField.getText().equals( " " ) )
							|| ( teamField.getText().equals( " " ) ) || ( heightField.getText().equals( " " ) ) 
							|| ( weightField.getText().equals( " " ) ) || ( ageField.getText().equals( " " ) ) ) ;
							
							if ( fieldsBlank )  // if any of the fields are empty
							{
								JOptionPane.showMessageDialog( null, "User must completely fill all fields before" +
										" attempting to add a new player.", "Error", JOptionPane.ERROR_MESSAGE );
							}
							else  // otherwise
							{
								// set the player's attributes
								player.setName( nameField.getText().trim() );
								player.setJerseyNum( Integer.parseInt( numberField.getText().trim() ) );
								player.setPosition( positionField.getText().trim() );
								player.setTeam( teamField.getText().trim() );
								player.setHeight( heightField.getText().trim() );
								player.setWeight( Integer.parseInt( weightField.getText().trim() ) );
								player.setAge( Integer.parseInt( ageField.getText().trim() ) );
							
								try 
								{   // add the new player
									NBADatabase.addPlayer( player );
									NBADatabase.playerMap.put( player.getName() , player );
								} 
								catch (Exception e1) 
								{
									e1.printStackTrace();
								}
								
								JOptionPane.showMessageDialog( null, "Player successfully added!" );
							
								SwingUtilities.invokeLater( new Runnable()
								{
										@Override
										public void run()   // close the window
										{
											NBADatabaseUI.addPlayerFrame.dispose();
										}
								} );
							}
						}
					}
				} );
		
	// -------------------------------------------------------------
		
	}
}
