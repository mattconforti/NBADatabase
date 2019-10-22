/**
 * A class which defines the NBATeam object.
 * All statistics and information are current as of the 2016-2017 NBA season.
 *
 * @author Matt Conforti
 */
public class NBATeam 
{
	/** The name of the {@link NBATeam}. */
	private String teamName;
	
	/** The number of rings or championships this {@link NBATeam} has accumulated since it's creation. */
	private int championshipsWon;
	
	/** The path name or location of this {@link NBATeam}'s logo on this machine. */
	private String teamLogoPath;
	
	/** Creates a new {@link NBATeam}. */
	public NBATeam() 
	{
		this.setTeamName( "" );
		this.setChampionshipsWon( 0 ); 
		this.setTeamLogoPath( "" );
	}

	public String getTeamName() 
	{
		return teamName;
	}

	public void setTeamName( String teamName ) 
	{
		this.teamName = teamName;
	}

	public int getChampionshipsWon() 
	{
		return championshipsWon;
	}

	public void setChampionshipsWon( int championshipsWon ) 
	{
		this.championshipsWon = championshipsWon;
	}

	public String getTeamLogoPath() 
	{
		return teamLogoPath;
	}

	public void setTeamLogoPath( String teamLogoPath ) 
	{
		this.teamLogoPath = teamLogoPath;
	}
}
