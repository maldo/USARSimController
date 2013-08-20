package interfaces;

/**
 * 
 * @author Alberto Maldonado
 */
public class Utils
{

	public static final boolean Debug = false;
		
	public static String partialString(String str, String field, String limit,
			int pos)
	{
		int i = str.indexOf(field, pos);

		String fieldstr = "";

		if (i == -1)
		{
			// TODO exception?
		}
		else
		{
			i = i + field.length();

			int end = str.indexOf(limit, i);

			fieldstr = str.substring(i + 1, end);
		}

		return fieldstr;
	}
}
