package approvecomment;

import java.sql.Connection;
import java.sql.DriverManager;

import approvecomment.db.Comment;
import approvecomment.db.CommentManager;

public class ApproveCommentImpl implements ApproveComment {

	CommentManager cm = new CommentManager();

	@Override
	public String filter(String comment, String username) {
		ProfanityFilter filter = new ProfanityFilter();
		filter.buildDictionaryTree("demo_eng.txt");
		String result = filter.filterBadWords(comment);
		Comment c = new Comment(comment, username);

		if (result.contains("*")) {
			Boolean res = cm.createComment(c);
			System.out.println("added to db  " + res);

		}

		System.out.println("Result " + result);
		return result;
	}

	@Override
	public int getOccurences(String username) {
		return cm.getOccurencesforUser(username);
	}

}
