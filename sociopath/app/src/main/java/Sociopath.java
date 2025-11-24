import java.util.List;

public class Sociopath {
	/**
	 * Identify the sociopath in a group based on who is liked by everyone else but likes no one.
	 * @param groupSize Number of people in the group
	 * @param likeList List of pairs that indicate who likes who
	 * @return The integer of the sociopath if they exist or -1 if no sociopath found
	 */
	public int findTheSociopath(int groupSize, List<int[]> likeList) {
		//If groupSize is 0 or negative then return -1
		if (groupSize <= 0) {
			return -1;
		}

		//Initialize arrays to track likes (who they like and who likes them)
		int[] likes = new int[groupSize + 1];
		int[] likedBy = new int[groupSize + 1];

		//Iterate through each pair in the list
		for (int[] pair : likeList) {
			int source = pair[0]; //liking someone else
			int target = pair[1]; //is being liked by someone

			//Check if a and b are real people and exist in a group
			if (source > 0 && target > 0 && source <= groupSize && target <= groupSize) {
				likes[source]++; //source likes someone, so their count increments
				likedBy[target]++; //target is liked by someone, so their count increments
			}
		}

		//Iterate through every person to see if anyone matches the guidelines to identify sociopath
		for (int person = 1; person <= groupSize; person++) {
			if (likedBy[person] == groupSize - 1 && likes[person] == 0) {
				return person; //Found sociopath
			}
		}
		return -1;
	}
}

