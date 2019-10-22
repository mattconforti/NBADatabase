import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/** 
 * The database of all current {@link NBAPlayer}s and their respective information and statistics.
 * 
 * @author Matt Conforti
 */
public class NBADatabase 
{
	/** Boolean value to tell if the current user is an administrator or not. */
	protected static boolean admin = false;
	
	/** The {@link HashMap} object used to store usernames and their associated passwords for log in purposes. */
	private static HashMap<String,char []> acceptedUsrPswd = new HashMap<String, char []>();
	
	/** The {@link HashMap} object used to store {@link NBAPlayer} objects using their names as a key. */
	protected static HashMap<String,NBAPlayer> playerMap = new HashMap<String,NBAPlayer>();
	
	/** The {@link HashMap} object used to store {@link NBATeam} objects using their name as a key. */
	protected static HashMap<String,NBATeam> teamMap = new HashMap<String,NBATeam>();
	
	/** The text file which contains all players and their respective information. */
	private static File playersFile = new File( "Players.txt" );
	
	private static File  teamsFile = new File("NBATeams.txt");

	/**
	 * A method to load the database with all existing {@link NBAPlayer}s and their respective information.
	 * 
	 * @throws Exception if there is an exception while reading in the {@link File}.
	 */
	public static void loadDatabase() throws Exception
	{
		if( !( playersFile.exists() ) )       // if the file does not exist
		{
			throw new FileNotFoundException( "The file '" + playersFile.getName() + "' does not exist" );	
		}
		else    // otherwise, read in the file and process it accordingly
		{
			FileReader fR = new FileReader( playersFile );
			BufferedReader bR = new BufferedReader( fR );
			String line;
			
			try 
			{
				while( ( line = bR.readLine() ) != null )  // while there are lines remaining to process
				{
					NBAPlayer newPlayer = new NBAPlayer();  // create a new NBAPlayer
					String [] playerInfo = line.split( "-" );
					newPlayer.setName( playerInfo[0] );       // set the appropriate values to that NBAPlayer
					newPlayer.setJerseyNum( Integer.parseInt( playerInfo[1] ) );
					newPlayer.setTeam( playerInfo[2] );
					newPlayer.setPosition( playerInfo[3] );
					newPlayer.setHeight( playerInfo[4] );
					newPlayer.setWeight( Integer.parseInt( playerInfo[5] ) );	
					newPlayer.setAge( Integer.parseInt( playerInfo[6] ) );
					
					try  // try to find an image for this new player
					{
						newPlayer.setImagePath( playerInfo[7] );
					}
					catch( Exception e ) // if the image is not available
					{
						System.out.println( "Player image unavailable for " + newPlayer.getName() + " ( " + e + " )");  // print the error
					}
					
					playerMap.put( newPlayer.getName(),newPlayer );  // put the player into the HashMap
				}
			} 
			finally
			{
				if ( bR != null ){
					bR.close();
				}
				if( fR != null ){
					fR.close();
				}
			}
		}
	}
	
	/**
	 * A method to load all {@link NBATeam}s in the NBA. 
	 * 
	 * @param teamMap The {@link HashMap} object used to store all teams.
	 * 
	 */
	public static void loadNBATeams( HashMap<String,NBATeam> teamMap ) throws Exception
	{
		if( !( teamsFile.exists() ) ){
			throw new FileNotFoundException("The file" + teamsFile.getName() + "does not exist" );
		}
		else { //read all Teams
			
			FileReader teamRead = new FileReader( teamsFile );
			BufferedReader tR = new BufferedReader( teamRead );
			String lineIn;
			
			try{
				while( ( lineIn = tR.readLine() ) != null )
				{
					NBATeam newTeam = new NBATeam();
					String [] teamInfo = lineIn.split("-");
					newTeam.setTeamName(teamInfo[1]);
					newTeam.setChampionshipsWon( Integer.parseInt( teamInfo[1] ) );
					newTeam.setTeamLogoPath( teamInfo[2] );
					
					teamMap.put(newTeam.getTeamName(), newTeam);
				}
			}
			finally
			{
				if ( tR != null ){
					tR.close();
				}
				if( teamRead != null ){
					teamRead.close();
				}
			}
		}
	}
	
	/**
	 * A method to add a player to the database ( Admin only ) .
	 * Only users with administrative qualifications can access this method.
	 * 
	 * @param newPlayer The {@link NBAPlayer} to be added to the database.
	 * 
	 * @throws Exception If there is an error writing to the file.
	 */
	public static void addPlayer( NBAPlayer newPlayer ) throws Exception
	{
		if( !( playersFile.exists() ) )    // if the file does not exist - throw an exception
		{
			throw new FileNotFoundException( "The file '" + playersFile.getName() + "' does not exist" );	
		}
		else  // otherwise, add the new player at the end of the file
		{	
			FileWriter fW = new FileWriter( playersFile, true ); // file writer which appends text to the file
			BufferedWriter bW = new BufferedWriter( fW );        // wrap in buffered reader
				
			try
			{
				bW.write( "\n" + newPlayer.getName() + "-" + newPlayer.getJerseyNum() + "-" +
						newPlayer.getTeam() + "-" + newPlayer.getPosition() + "-" + newPlayer.getHeight()
						+ "-" + newPlayer.getWeight() + "-" + newPlayer.getAge() );
				
				if( ! ( newPlayer.getImagePath().equals( "" ) ) )   // if the player has an associated image
				{
					bW.write( "-" + newPlayer.getImagePath() );   // write the path to the file
				}
			}
			finally
			{
				if ( bW != null )
				{
					bW.close();
				}
				if( fW != null )
				{
					fW.close();
				}
			}
		}
	}
	
	/**
	 * A method to check the username and password of the user when attempting to log in.
	 * 
	 * @param usrname The username of the user.
	 * 
	 * @param passWd The password of the user.
	 * 
	 * @return True if the username and password match the pair that is on record. Otherwise, false.
	 */
	public static boolean checkUsrPswd( String usrname, char [] passWd )
	{
		char [] mattPassWd = { '1','0','2','8','1','9','9','7' };
		char [] shelbyPassWd = { 'W','i','l','d','w','o','o','d','@','2' };
		char [] dadPassWd = { 'k','n','i','c','k','s','2','0','1','7' };
		
		// load the Map with all accepted username/password combinations
		acceptedUsrPswd.put( "mattconforti21", mattPassWd ); // Matt
		acceptedUsrPswd.put( "Pconforti1", dadPassWd );	     // Dad
		acceptedUsrPswd.put( "ShelbC", shelbyPassWd);        // Shell
		
		if( acceptedUsrPswd.keySet().contains( usrname ) )  // if the username is correct
		{
			char [] correctPassWd = acceptedUsrPswd.get( usrname );   // fetch the correct password for that username
			
			if( Arrays.equals( correctPassWd , passWd ) )
			{
				Arrays.fill( correctPassWd, '0' );   // zero out the 'correctPassWd' variable 
				return true;
			}
			
			Arrays.fill( correctPassWd, '0' );   // zero out the 'correctPassWd' variable
		}
		return false;
	}
}
