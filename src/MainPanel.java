import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

/**
 * The main {@link JPanel} which is used in the {@link NBADatabaseUI} GUI program.
 * It is divided into two smaller panels, the {@link TopPanel} and the {@link BottomPanel}.
 * 
 * @author Matt Conforti
 */
public class MainPanel extends JPanel
{
	/** The top of the {@link MainPanel}. */
	private final TopPanel topPanel;
	
	/** The bottom panel of the {@link MainPanel}.  */
	private final BottomPanel bottomPanel;
	
	/** Creates a new instance of {@link MainPanel}.  */
	public MainPanel()
	{
		super( new GridBagLayout() );
		
		this.topPanel = new TopPanel();
		this.bottomPanel = new BottomPanel();
		
		this.add( topPanel,
				new GridBagConstraints( 0, 0,
						GridBagConstraints.REMAINDER, 1,
						1.0, 1.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.BOTH,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
		
		this.add( new JSeparator(),
				new GridBagConstraints( 0, 1,
						GridBagConstraints.REMAINDER, 1,
						1.0, 0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.HORIZONTAL,
						new Insets( 0, 0, 0, 0 ), 0, 0 ) );
		
		this.add( bottomPanel,
				new GridBagConstraints( 0, 2,
						GridBagConstraints.REMAINDER, 1,
						1.0, 0.0,
						GridBagConstraints.FIRST_LINE_END,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
	}
	
	/** 
	 * The class which defines the top of the {@link MainPanel}.
	 * 
	 * @author Matt Conforti
	 */
	public static class TopPanel extends JPanel
	{
		/** The {@link JLabel} which contains an image of the Logo for the National Basketball Association. */
		private final JLabel NBALogo;
		
		/** The non-editable {@link JTextField} which acts as a label to display the text 'Player Name'. */
		private final JTextField playerLabel;
		
		/** The {@link JTextField} which allows users to search for a specific {@link NBAPlayer}. */
		private JTextField playerSearchBar;
		
		/** The non-editable {@link JTextField} which acts as a label to display the text 'Team Name'. */
		private final JTextField teamLabel;
		
		/** The {@link JTextField} which allows users to search for a specific team. */
		private JTextField teamSearchBar;
		
		/** The {@link JButton} which enables the user to log-in as an administrator. */
		public static JButton logInButton;
		
		/** The {@link JButton} which enables the user to add an {@link NBAPlayer} to the database ( Admin only ). */
		private final JButton addPlayerButton;
		
		/** The {@link JButton} which enables the user to edit an existing {@link NBAPlayer} ( Admin only ). */
		private final JButton editPlayerButton;
		
		/** The {@link JButton} which enables the user to search the database for a specific {@link NBAPlayer}. */
		private final JButton playerSearchButton;
		
		/** The {@link JButton} which enables the user to search the database for a specific team. */
		private final JButton teamSearchButton;
		
		/** Creates a new instance of {@link TopPanel}. */
		public TopPanel()
		{
			super( new GridBagLayout() );
			
		// NBA Logo
		// -------------------------------------------------------------
			
			ImageIcon logoImage = new ImageIcon( "/Users/mattconforti/Desktop/Java/workspace/NBAProject/NBALogo.png" );
			ImageIcon resizedLogo = new ImageIcon( logoImage.getImage().getScaledInstance( 112, 255, Image.SCALE_SMOOTH ) );
			this.NBALogo = new JLabel( resizedLogo );
			
			this.add( NBALogo,
					new GridBagConstraints( 0, 0,
							1, GridBagConstraints.REMAINDER,
							0.0, 0.0,
							GridBagConstraints.WEST,
							GridBagConstraints.NONE,
							new Insets( 10, 30, 5, 30 ), 0, 0 ) );
			
			// TODO - implement Easter egg which allows user to click on this image and have it display
		    //        details and information about the NBA Logo including origin and the player it features.
		
		// Vertical Separator
		// -------------------------------------------------------------
			
			this.add( new JSeparator( SwingConstants.VERTICAL ), 
					new GridBagConstraints( 1, 0,
							1, GridBagConstraints.REMAINDER,
							0.0, 0.0,
							GridBagConstraints.WEST,
							GridBagConstraints.VERTICAL,
							new Insets( 0, 0, 0, 0 ), 0, 0 ) );
			
		// Player Labels & Search Bar	
		// -------------------------------------------------------------
			
			this.add( new JLabel( "Search by Player..." ),
					new GridBagConstraints( 2, 0,
							1, 1,
							1.0, 1.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.NONE,
							new Insets( 5, 15, 5, 5 ), 0, 0 ) );
			
			this.playerLabel = new JTextField( " Player Name: ", 8 );
			playerLabel.setEnabled( true );
			playerLabel.setEditable( false );
			playerLabel.setBackground( new JLabel().getBackground() );
			playerLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
			this.add( playerLabel, 
					new GridBagConstraints( 2, 1,
							1, 1,
							1.0, 1.0,
							GridBagConstraints.NORTH,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
			this.playerSearchBar = new JTextField( " Type Player Name Here...", 15 );
			playerSearchBar.setBackground( new JLabel().getBackground() );
			playerSearchBar.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
			this.add( playerSearchBar,
					new GridBagConstraints( 3, 1,
							1, 1, 
							1.0, 1.0,
							GridBagConstraints.NORTH,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
			playerSearchBar.addMouseListener( new MouseAdapter()
					{
						@Override
			            public void mouseClicked( MouseEvent e )
						{
			                playerSearchBar.setText( " " );
			                NBADatabaseUI.mainFrame.getRootPane().setDefaultButton( playerSearchButton );
						}
					} );
			
		// Team Labels & Search Bar
		// -------------------------------------------------------------
			
			this.add( new JLabel( "Search by Team..."),
					new GridBagConstraints( 2, 2,
							1, 1,
							1.0, 1.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.NONE,
							new Insets( 5, 15, 5, 5 ), 0, 0 ) );
			
			this.teamLabel = new JTextField( " Team Name: ", 8 );
			teamLabel.setEnabled( true );
			teamLabel.setEditable( false );
			teamLabel.setBackground( new JLabel().getBackground() );
			teamLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
			this.add( teamLabel,
					new GridBagConstraints( 2, 3,
							1, 1, 
							1.0, 1.0,
							GridBagConstraints.NORTH,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
			this.teamSearchBar = new JTextField( " Type Team Name Here...", 15 );
			teamSearchBar.setBackground( new JLabel().getBackground() );
			teamSearchBar.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
			
			this.add( teamSearchBar,
					new GridBagConstraints( 3, 3,
							1, 1, 
							1.0, 1.0,
							GridBagConstraints.NORTH,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 5, 5 ), 0, 0 ) );
			
			teamSearchBar.addMouseListener( new MouseAdapter()
					{
						@Override
						public void mouseClicked( MouseEvent e )
						{
							teamSearchBar.setText( " " );
							NBADatabaseUI.mainFrame.getRootPane().setDefaultButton( teamSearchButton );;
						}
					} );
			
		// Log in Button	
		// -------------------------------------------------------------
			
			this.logInButton = new JButton( "  Log in   " );
			
			this.add( logInButton,
					new GridBagConstraints( 2, 4,
							1, 1,
							0.0, 0.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.NONE,
							new Insets( 5, 0, 5, 5 ), 0, 0 ) );
			
			logInButton.addActionListener( new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							if( NBADatabase.admin )
							{
								int result = JOptionPane.showConfirmDialog( null, "Are you sure you wish to log out?", 
										"Confirm Exit",JOptionPane.YES_NO_OPTION );
								if( result == JOptionPane.YES_OPTION ){
									NBADatabase.admin = false;   // log the user out
									logInButton.setText( "  Log in   " );
							}
							}
							else
							{
								SwingUtilities.invokeLater( new Runnable()
										{
											@Override
											public void run() 
											{
												NBADatabaseUI.openLogInWindow();
											}
										} );
							}
						}
					} );
		
		// Add Player Button
		// --------------------------------------------------------------
			
			this.addPlayerButton = new JButton( " Add Player" );
			
			this.add( addPlayerButton,
					new GridBagConstraints( 3, 4, 
							1, 1, 
							0.0, 0.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 5, 20 ), 0, 0 ) );
			
			addPlayerButton.addActionListener( new ActionListener()
					{
						@Override
						public void actionPerformed( ActionEvent e ) 
						{
							if( !( NBADatabase.admin ) )
							{
								JOptionPane.showMessageDialog( null, "Cannot access this feature unless the "
										+ "user is logged in as an administrator.", 
										"Error", JOptionPane.ERROR_MESSAGE );
							}
							else
							{
								SwingUtilities.invokeLater( new Runnable()
										{
											@Override
											public void run() 
											{
												NBADatabaseUI.openAddPlayerWindow();
											}
										} );
							} 
						}
					} );
			
		// Edit Player Button
		// --------------------------------------------------------------
			
			this.editPlayerButton = new JButton( "Edit Player" );
			
			this.add( editPlayerButton,
					new GridBagConstraints( 4, 4,
							1, 1, 
							0.0, 1.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 5, 45 ), 0, 0 ) );
			
			editPlayerButton.addActionListener( new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							if( !( NBADatabase.admin ) )
							{
								JOptionPane.showMessageDialog( null, "Cannot access this feature unless the "
										+ "user is logged in as an administrator.", 
										"Error", JOptionPane.ERROR_MESSAGE );
							}
							else
							{
								String editVal = JOptionPane.showInputDialog(null, "Which player would you like to edit?"
										, "Enter Player Name", JOptionPane.QUESTION_MESSAGE );
								
								if( ! ( editVal == null ) )   // check to see if the user selects cancel
								{
									if( ! ( NBADatabase.playerMap.containsKey( editVal ) ) )   // check if the player is not in the database
									{
										JOptionPane.showMessageDialog( null , "'" + editVal + "' is not currently in the database.", "Error"
												, JOptionPane.ERROR_MESSAGE );
									}
									else
									{
										System.out.println( "TODO: bring open a popup window to edit the player" );
										NBADatabaseUI.openEditPlayerWindow( editVal );
									}
								}
							}
						}
					} );
			
		// Player Search Button
		// --------------------------------------------------------------
			
			this.playerSearchButton = new JButton( "Search" );
			
			this.add( playerSearchButton,
					new GridBagConstraints( 4, 1,
							1, 1,
							0.0, 1.0,
							GridBagConstraints.NORTH,
							GridBagConstraints.NONE,
							new Insets( 1, 5, 5, 20 ), 0, 0 ) );
			
			playerSearchButton.addActionListener( new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							if( !( playerSearchBar.getText().equals( " " ) ) ) // if the user types in the search bar
							{
								if( !( playerSearchBar.getText().equals( " Type Player Name Here..." ) ) )
								{
									SwingUtilities.invokeLater( new Runnable()
											{
												@Override
												public void run() 
												{
													if( NBADatabase.playerMap.containsKey( playerSearchBar.getText().trim() ) )
													{
														NBADatabaseUI.openPlayerWindow( playerSearchBar.getText().trim() );
														playerSearchBar.setText( " Type Player Name Here..." );
													}
													else
													{
														JOptionPane.showMessageDialog( null, "The player '"
																+ playerSearchBar.getText().trim() + "' is not currently"
																+ " in the database.", "Error", JOptionPane.ERROR_MESSAGE );
													}	
												}
											} );
								}
							}
						}
					} );
			
		// Team Search Button
		// --------------------------------------------------------------
				
			this.teamSearchButton = new JButton( "Search" );
			
			this.add( teamSearchButton,
					new GridBagConstraints( 4, 3, 
							1, 1,
							0.0, 1.0,
							GridBagConstraints.NORTH,
							GridBagConstraints.NONE,
							new Insets( 1, 5, 5, 20 ), 0, 0 ) );
				
		// --------------------------------------------------------------
			
		}
	}
	
	/**
	 * The class which defines the bottom of the {@link MainPanel}.
	 * 
	 * @author Matt Conforti
	 */
	private class BottomPanel extends JPanel
	{
		/** The {@link JButton} which displays info to the user about correct operation of the program. */
		private JButton helpButton;
		
		/** The {@link JButton} which allows the user to exit the program safely. */
		private JButton quitButton;
		
		/** Creates a new instance of {@link BottomPanel}. */
		public BottomPanel()
		{
			super( new GridBagLayout() );
			
		// Help Button
		// -----------------------------------------------------------------
			
			this.helpButton = new JButton( "Help" );
			
			this.add( helpButton, 
					new GridBagConstraints( 0, 1,
							1, 1,
							0.5, 0.0,
							GridBagConstraints.LAST_LINE_END,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 10, 0 ), 0, 0 ) );	
			
			helpButton.addActionListener( new ActionListener() 
					{
						@Override
						public void actionPerformed( ActionEvent e ) 
						{
							JOptionPane.showMessageDialog( null, "To access administrative privileges... "
									+ "|    click the 'Log in' button and enter your information."
									+ "\n---------------------------------------------------------------------"
									+ "\nTo search for a specific player... "
									+ "        |    type that player's name in the 'Player Name' search bar."
									+ "\n---------------------------------------------------------------------"
									+ "\nTo search for an entire team... "
									+ "           |    type that team's name in the 'Team Name' search bar."
									+ "\n---------------------------------------------------------------------"
									+ "\nTo add a player to the database... "
									+ "      |    click the 'Add Player' button ( Admin only )."
									+ "\n---------------------------------------------------------------------"
									+ "\nTo edit an existing player..."
									+"                |    click the 'Edit Player' button ( Admin only )."
									+ "\n---------------------------------------------------------------------"
									+ "\nTo Log Out...                       "
									+ "                |    click the 'Log Out' Button ( Admin Only )."
									+ "\n---------------------------------------------------------------------"
									, "Help", JOptionPane.INFORMATION_MESSAGE );
						}
					} );
		
		// Quit Button
		// -----------------------------------------------------------------
			
			this.quitButton = new JButton( "Quit" );
			
			this.add( quitButton,
					new GridBagConstraints( 1, 1,
							1, 1,
							0.0, 0.0,
							GridBagConstraints.LAST_LINE_END,
							GridBagConstraints.NONE,
							new Insets( 5, 5, 10, 10 ), 0, 0 ) );
			
			quitButton.addActionListener( new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							int result = JOptionPane.showConfirmDialog( null, "Are you sure you wish to exit?", 
									"Confirm Exit",JOptionPane.YES_NO_OPTION );
							if( result == JOptionPane.YES_OPTION ){
								System.exit( 0 );
							}
						}
					} );
			
		// ------------------------------------------------------------------
			
		}
	}
}
