/**
 * A class which defines the NBAPlayer object.
 * All statistics and information are current as of the 2016-2017 NBA season.
 * 
 * @author Matt Conforti
 */
public class NBAPlayer 
{
	/** The name of the {@link NBAPlayer}. */
	private String name;
	
	/** The {@link NBAPlayer}'s jersey number. */
	private int jerseyNum;
	
	/** The current team of the {@link NBAPlayer}. */
	private String team;
	
	/** The position of the {@link NBAPlayer}. */
	private String position;
	
	/** The height of the (@link NBAPlayer}. Formatted as ' #feet' #inches" '. */
	private String height;
	
	/** The weight in pounds of the {@link NBAPlayer}. */
	private int weight;
	
	/** The age in years of the {@link NBAPlayer}. */
	private int age;
	
	/** The path of the {@link NBAPlayer}'s profile image. */
	private String imagePath;
	
	/** Creates a new {@link NBAPlayer}. */
	public NBAPlayer()
	{
		this.setName( "" );
		this.setJerseyNum( 0 );
		this.setTeam( "" );
		this.setPosition( "" );
		this.setHeight( "0'0\"" );
		this.setWeight( 0 );
		this.setAge( 0 );
		this.setImagePath( "" );
	}

	/** Getter method for the 'name' field.
	 * 
	 * @return name The name of the {@link NBAPlayer}.
	 */
	public String getName() 
	{
		return name;
	}

	/** Setter method for the 'name' field.
	 *
	 * @param name The name of the {@link NBAPlayer}.
	 */
	public void setName( String name ) 
	{
		this.name = name;
	}

	/** Getter method for the 'jerseyNum' field.
	 * 
	 * @return jerseyNum The jersey number of the {@link NBAPlayer}.
	 */
	public int getJerseyNum() 
	{
		return jerseyNum;
	}

	/** Setter method for the 'jerseyNum' field.
	 *
	 * @param jerseyNum The jersey number of the {@link NBAPlayer}.
	 */
	public void setJerseyNum( int jerseyNum ) 
	{
		this.jerseyNum = jerseyNum;
	}

	/** Getter method for the 'team' field.
	 * 
	 * @return team The current team of the {@link NBAPlayer}.
	 */
	public String getTeam() 
	{
		return team;
	}

	/** Setter method for the 'team' field.
	 *
	 * @param team The current team of the {@link NBAPlayer}.
	 */
	public void setTeam( String team ) 
	{
		this.team = team;
	}

	/** Getter method for the 'position' field.
	 * 
	 * @return position The position of the {@link NBAPlayer}.
	 */
	public String getPosition() 
	{
		return position;
	}

	/** Setter method for the 'position' field.
	 *
	 * @param position The position of the {@link NBAPlayer}.
	 */
	public void setPosition( String position ) 
	{
		this.position = position;
	}

	/** Getter method for the 'height' field.
	 * 
	 * @return height The height of the {@link NBAPlayer}.
	 */
	public String getHeight() 
	{
		return height;
	}

	/** Setter method for the 'height' field.
	 *
	 * @param height The height of the {@link NBAPlayer}.
	 */
	public void setHeight( String height ) 
	{
		this.height = height;
	}

	/** Getter method for the 'weight' field.
	 * 
	 * @return weight The weight of the {@link NBAPlayer}.
	 */
	public int getWeight() 
	{
		return weight;
	}

	/** Setter method for the 'weight' field.
	 *
	 * @param weight The weight of the {@link NBAPlayer}.
	 */
	public void setWeight( int weight ) 
	{
		this.weight = weight;
	}

	/** Getter method for the 'age' field.
	 * 
	 * @return age The age of the {@link NBAPlayer}.
	 */
	public int getAge() 
	{
		return age;
	}

	/** Setter method for the 'age' field.
	 *
	 * @param age The age of the {@link NBAPlayer}.
	 */
	public void setAge( int age ) 
	{
		this.age = age;
	}
	
	/**
	 * Getter method for the 'imagePath' field.
	 * 
	 * @return imagePath The path of the {@link NBAPlayer}'s profile image.
	 */
	public String getImagePath()
	{
		return imagePath;
	}
	
	/**
	 * Setter method for the 'imagePath' field.
	 * 
	 * @param imagePath The path of the {@link NBAPlayer}'s profile image.
	 */
	public void setImagePath( String imagePath )
	{
		this.imagePath = imagePath;
	}
}
