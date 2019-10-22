import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

/**
 * A {@link JPanel} which is used in the {@link NBADatabaseUI} program.
 * Serves the purpose of allowing the user to log in and access administrative privileges. 
 * 
 * @author Matt Conforti
 */
public class LogInPanel extends JPanel
{
	/** The non-editable {@link JTextField} which acts as a label to display the text 'Username:'. */
	private final JTextField usernameLabel;
	
	/** The {@link JTextField} which allows the user to enter his/her username.*/
	protected JTextField usernameField;
	
	/** The non-editable {@link JTextField} which acts as a label to display the text 'Password:'. */
	private final JTextField passwordLabel;
	
	/** The {@link JTextField} which allows the user to enter his/her password. */
	protected JPasswordField passwordField;
	
	/** The {@link JButton} which allows users to submit their username and password and potentially log in. */
	private final JButton logInButton;
	
	/** The boolean value which determines if the username and password match the pair on record. */
	private boolean isMatch;
	
	/** Creates a new {@link LogInPanel} */
	public LogInPanel()
	{
		super( new GridBagLayout() );
		
	// Username Label & Field
	// -------------------------------------------------------------
		
		this.usernameLabel = new JTextField(" Username:  ");
		usernameLabel.setEnabled( true );
		usernameLabel.setEditable( false );
		usernameLabel.setBackground( new JLabel().getBackground() );
		usernameLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add(usernameLabel,
				new GridBagConstraints( 0, 0,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
		
		this.usernameField = new JTextField( "", 14 );
		usernameField.setBackground( new JLabel().getBackground() );
		usernameField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( usernameField,
				new GridBagConstraints( 1, 0,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
		
	// Password Label & Field
	// -------------------------------------------------------------
		
		this.passwordLabel = new JTextField(" Password:   ");
		passwordLabel.setEnabled( true );
		passwordLabel.setEditable( false );
		passwordLabel.setBackground( new JLabel().getBackground() );
		passwordLabel.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( passwordLabel,
				new GridBagConstraints( 0, 1,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
		
		this.passwordField = new JPasswordField( "", 14 );
		passwordField.setBackground( new JLabel().getBackground() );
		passwordField.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ) );
		
		this.add( passwordField,
				new GridBagConstraints( 1, 1,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.NONE,
						new Insets( 5, 5, 5, 5 ), 0, 0 ) );
		
	// Log in Button
	// -------------------------------------------------------------
		
		this.logInButton = new JButton("Log in");
		NBADatabaseUI.logInFrame.getRootPane().setDefaultButton( logInButton );   // allow this button to respond to the 'enter' key
		
		this.add( logInButton,
				new GridBagConstraints( 1, 2,
						1, 1,
						0.0, 0.0,
						GridBagConstraints.WEST,
						GridBagConstraints.NONE,
						new Insets( 10, 5, 5, 5 ), 0, 0 ) );
		
		logInButton.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						char [] password = passwordField.getPassword();
						isMatch = NBADatabase.checkUsrPswd( usernameField.getText().trim(), password );
						
						if( isMatch )  // if the username and password match
						{
							NBADatabase.admin = true;  // the user is now an admin
							JOptionPane.showMessageDialog( null , "Log in successful!");	
							
							SwingUtilities.invokeLater( new Runnable()   // close the log in frame
									{
										@Override
										public void run() 
										{
											MainPanel.TopPanel.logInButton.setText( "  Log out  " );   // change the button
											NBADatabaseUI.logInFrame.dispose();
										}
									} );
						}
						else  // otherwise, print error and clear the text fields
						{
							JOptionPane.showMessageDialog( null, "The username and/or password are incorrect!",
									"Error", JOptionPane.ERROR_MESSAGE );
							
							usernameField.setText( "" );
							passwordField.setText( "" );
						}
					}
				} );
		
	// -------------------------------------------------------------
		
	}
}
