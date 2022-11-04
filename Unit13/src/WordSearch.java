//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
	private String[][] m;

	public WordSearch( int size, String str )
	{
		m = new String[size][size];
		for(int r = 0; r<m.length; r++) {
			for(int c = 0; c<m[r].length; c++) {
				m[r][c] = "" + str.charAt(size*r + c);
			}
		}
	}

	public boolean isFound( String word )
	{
		for(int r = 0; r<m.length; r++) {
			for(int c = 0; c<m[r].length; c++) {
				if(checkRight(word, r, c) || checkLeft(word, r, c) || checkUp(word, r, c) || checkDown(word, r, c) ||
						checkDiagUpRight(word, r, c) || checkDiagUpLeft(word, r, c) || checkDiagDownRight(word, r, c) ||
						checkDiagDownLeft(word, r, c))
					return true;
			}
		}
		return false;
	}

	public boolean checkRight(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(c + i < 8) str+=m[r][c+i];
			else break;
		}
		return str.equals(w);
	}

	public boolean checkLeft(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(c - i >= 0) str+=m[r][c-i];
			else break;
		}
		return str.equals(w);
	}

	public boolean checkUp(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(r + i < 8) str+=m[r+i][c];
			else break;
		}
		return str.equals(w);
	}

	public boolean checkDown(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(r - i >= 0) str+=m[r-i][c];
			else break;
		}
		return str.equals(w);
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(c + i < 8 && r + i < 8) str+=m[r+i][c+i];
			else break;
		}
		return str.equals(w);
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(c - i >= 0 && r + i < 8) str+=m[r+i][c-i];
			else break;
		}
		return str.equals(w);
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(c - i >= 0 && r - i >= 0) str+=m[r-i][c-i];
			else break;
		}
		return str.equals(w);
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		String str = "";
		for(int i = 0; i < w.length(); i++) {
			if(c + i < 8 && r - i >= 0) str+=m[r-i][c+i];
			else break;
		}
		return str.equals(w);
	}

	public String toString()
	{
		String output = "";
		for(int r = 0; r < m.length; r++) {
			for(int c = 0; c < m[r].length; c++) {
				output+=m[r][c] + " ";
			}
			output+="\n";
		}
		return output;
	}
}
