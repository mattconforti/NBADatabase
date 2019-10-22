import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * The class that defines the user interface for the {@link NBADatabase} program.
 * 
 * @author Matt Conforti
 */
public class NBADatabaseUI 
{
	/** The {@link JFrame} which contains the main panel of the UI. */
	public static JFrame mainFrame;
	
	/** The {@link JFrame} which allows users to log in. */
	public static JFrame logInFrame;
	
	/** The {@link JFrame} which is used to display information/statistics about a specific {@link NBAPlayer}. */
	public static JFrame playerFrame;
	
	/** The {@link JFrame} which is used to allow administrators to add {@link NBAPlayer}s to the database. */
	public static JFrame addPlayerFrame;
	
	/** The {@link JFrame} which is used to allow administrators to edit existing {@link NBAPlayer}'s statistics and information. */
	public static JFrame editPlayerFrame;
	
	/** Main method - the entry point to the program. */
	public static void main( String[] args ) 
	{
		mainFrame = new JFrame( "NBA Database" );
		JPanel mainPanel = new MainPanel();
	
		mainFrame.add( mainPanel );
		mainFrame.pack();
		mainFrame.setSize( 700, 400 );
		mainFrame.setLocationRelativeTo( null );
		mainFrame.setResizable( false );
		
		mainFrame.addWindowListener( new WindowAdapter() 
				{
					@Override
					public void windowClosing( WindowEvent e )
					{
						System.exit(0);
					}	
				} );
		
		SwingUtilities.invokeLater( new Runnable()
				{
					@Override
					public void run() 
					{
						try 
						{
							NBADatabase.loadDatabase();  // load the database
						}
						catch ( Exception e ) 
						{
							e.printStackTrace();
						}
						
						mainFrame.setVisible( true );    // make the frame visible
					}
				} );
	}
	
	/** A method which opens a new window where the user can potentially log in to the system. */
	public static void openLogInWindow()
	{
		logInFrame = new JFrame( "Log in" );
		JPanel logInPanel = new LogInPanel();
		
		logInFrame.add( logInPanel );
		logInFrame.pack();
		logInFrame.setSize( 425, 175 );
		logInFrame.setLocationRelativeTo( null );
		logInFrame.setResizable( false );
		logInFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		
		SwingUtilities.invokeLater( new Runnable()
				{
					@Override
					public void run() 
					{
						logInFrame.setVisible( true );
					}
				} );
	}
	
	/** A method which opens a window where information/statistics are displayed for a specific {@link NBAPlayer}. 
	 * 
	 * @param playerName The name of the {@link NBAPlayer} this window will be opened for.
	 */
	public static void openPlayerWindow( String playerName )
	{
		playerFrame = new JFrame( "NBA Player" );
		JPanel playerPanel = new PlayerPanel( playerName );
		
		playerFrame.add( playerPanel );
		playerFrame.pack();
		playerFrame.setSize( 600, 375 );
		playerFrame.setLocationRelativeTo( null );
		playerFrame.setResizable( false );
		playerFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		
		SwingUtilities.invokeLater( new Runnable()
				{
					@Override
					public void run() 
					{
						playerFrame.setVisible( true );
					}
				} );
	}
	
	/** A method which opens a window which allows administrators to add {@link NBAPlayer}s to the database. */
	public static void openAddPlayerWindow()
	{
		addPlayerFrame = new JFrame( "Add Player" );
		JPanel addPlayerPanel = new AddPlayerPanel();
		
		addPlayerFrame.add( addPlayerPanel );
		addPlayerFrame.pack();
		addPlayerFrame.setSize( 350, 325 );
		addPlayerFrame.setLocationRelativeTo( null );
		addPlayerFrame.setResizable( false );
		addPlayerFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		
		SwingUtilities.invokeLater( new Runnable()
				{
					@Override
					public void run() 
					{
						addPlayerFrame.setVisible( true );
					}
				} );
	}
	
	/** A method which opens a window which allows administrators to edit existing {@link NBAPlayer}s.
	 * 
	 * @param playerName The name of the {@link NBAPlayer} the user wishes to edit.
	 */
	public static void openEditPlayerWindow( String playerName )
	{
		editPlayerFrame = new JFrame( "Edit Player" );
		JPanel editPlayerPanel = new EditPlayerPanel( playerName );
		
		editPlayerFrame.add( editPlayerPanel );
		editPlayerFrame.pack();
		editPlayerFrame.setSize( 350, 325 );
		editPlayerFrame.setLocationRelativeTo( null );
		editPlayerFrame.setResizable( false );
		editPlayerFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		
		SwingUtilities.invokeLater( new Runnable()
				{
					@Override
					public void run() 
					{
						editPlayerFrame.setVisible( true );
					}
				} );
	}
}
