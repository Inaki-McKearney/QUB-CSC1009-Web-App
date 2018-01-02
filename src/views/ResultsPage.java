package views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.h2.mvstore.MVMap;

import model.Song;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class ResultsPage extends DynamicWebPage {

	public ResultsPage(DatabaseInterface db, FileStoreInterface fs) {
		super(db, fs);
	}
	
	//Searches map for songs with the searched tag, returns result arrayList
	public ArrayList<Song> getResultList(String search, ArrayList<Song> resultList){
		
		MVMap<String, Song> songsMap = db.s.openMap("Songs");
		
		ArrayList<Song> songList = new ArrayList<Song>();

		try {
			List<String> songKeys = songsMap.keyList();

			// Retrieve songs
			System.out.println("\n Songs stored: " + songKeys.size() + "\nsongKeys: " + songKeys);
			for (int i = 0; i < songKeys.size(); i++) {
				Song song = songsMap.get(songKeys.get(i));
				songList.add(song);
				System.out.println("\nID: " + song.youtubeID + "\nTitle: " + song.title);
			}
			System.out.println("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		shuffles result arrayList
		Random seed = new Random();
//		added above seed as results repeated without
		Collections.shuffle(songList, seed);
		
		int resultCount = 0;

		for (int i = 0; i < songList.size(); i++) {
			if (songList.get(i).tag.toLowerCase().contains(search)) {
				resultList.set(resultCount, songList.get(i));
				resultCount++;
			}
			if (resultCount > 3)
				break;
		}
		
		return resultList;
	}

	public boolean process(WebRequest toProcess) {

		//Creates song map
		MVMap<String, Song> songsMap = db.s.openMap("Songs");
		songsMap.clear();
		
		ArrayList<Song> tempArrayList = new ArrayList<Song>();
		tempArrayList = getSongArray();
		
		//Populates map with data from arrayList
		for(Song song : tempArrayList) {
			songsMap.put(song.youtubeID, song);
		}
		
		db.commit();
		
		//Sets result arraylist with 4 empty songs
		ArrayList<Song> resultList = new ArrayList<Song>();
		for (int i = 0; i < 4; i++) {
			resultList.add(getSongArray().get(0));
		}
		
		
		if (toProcess.path.equalsIgnoreCase("ResultsPage.html/sad") || toProcess.path.equalsIgnoreCase("ResultsPage.html/happy") || toProcess.path.equalsIgnoreCase("ResultsPage.html/angry") || toProcess.path.equalsIgnoreCase("ResultsPage.html/chill") || toProcess.path.equalsIgnoreCase("ResultsPage.html/upbeat") || toProcess.path.equalsIgnoreCase("ResultsPage.html/romantic") || toProcess.path.equalsIgnoreCase("ResultsPage.html/deep")) {
			
			//Gets what is after the / in the URL and sets it to the search
			String search = toProcess.path.split("/")[1];
			
			ArrayList<Song> playList = getResultList(search, resultList);			
			
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<html><head>\n";
			stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "    <link href=\"http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "  </head><body>\n";
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
			stringToSendToWebBrowser += "            <ul class=\"nav nav-justified nav-pills\">\n";
			stringToSendToWebBrowser += "              <li>\n";
			stringToSendToWebBrowser += "               <a href=\"/LandingPage.html\"> Home </a>\n";
			stringToSendToWebBrowser += "              </li>\n";
			stringToSendToWebBrowser += "              <li>\n";
			stringToSendToWebBrowser += "               <a href=\"/ContactUs.html\"> Contact Us </a>\n";
			stringToSendToWebBrowser += "              </li>\n";
			//DELETED PERSONAL PAGE LINK, USING FORM INSTEAD

			stringToSendToWebBrowser += "            </ul>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-10 text-center\">\n";
			stringToSendToWebBrowser += "            <h1 class=\"text-primary\">\n";
			stringToSendToWebBrowser += "              <b>Results</b>\n";
			stringToSendToWebBrowser += "            </h1>\n";
                        
                        //PERSONAL PAGE LOG IN FORM
			stringToSendToWebBrowser += "            <form class=\"text-right\" role=\"form\" action = \"/personalpage.html\" method = \"get\">\n";
			stringToSendToWebBrowser += "              <div class=\"imgcontainer\"></div>\n";
			stringToSendToWebBrowser += "				<p> Personal Page Log in </p>\n";
			stringToSendToWebBrowser += "              <label>\n";
			stringToSendToWebBrowser += "                <b>Email</b>\n";
			stringToSendToWebBrowser += "              </label>\n";
			stringToSendToWebBrowser += "                  <input type=\"email\"  id=\"userEmail\" placeholder=\"Email\" name = \"userEmail\">\n";
			stringToSendToWebBrowser += "              <br>\n";
			stringToSendToWebBrowser += "              <label>\n";
			stringToSendToWebBrowser += "                <b>Password</b>\n";
			stringToSendToWebBrowser += "              </label>\n";
			stringToSendToWebBrowser += "                  <input type=\"password\"  id=\"userPassword\" placeholder=\"Password\" name = \"userPassword\">\n";
			stringToSendToWebBrowser += "              <br>\n";
			stringToSendToWebBrowser += "                    <button type=\"submit\" class=\"btn btn-default\">Sign in</button>\n";
			stringToSendToWebBrowser += "            </form>\n";
                        //END OF FORM HTML FOR LOGIN

			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-6\">\n";
			stringToSendToWebBrowser += "            <div class=\"embed-responsive embed-responsive-16by9\">\n";
			stringToSendToWebBrowser += "              <iframe class=\"embed-responsive-item\" src=\"http://www.youtube.com/embed/" + resultList.get(0).youtubeID +"\" allowfullscreen=\"\"></iframe>\n";
			stringToSendToWebBrowser += "            </div>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "          <div=\"\" class=\"col-md-4\">\n";
			stringToSendToWebBrowser += "            <ul class=\"media-list\">\n";
			stringToSendToWebBrowser += "              <li class=\"media\">\n";
			stringToSendToWebBrowser += "                <a class=\"pull-left\"><img class=\"media-object\" src=\"http://maxpixel.freegreatpicture.com/static/photo/1x/Symbol-Beamed-Note-Beams-Music-Notes-25705.png\" height=\"64\" width=\"64\"></a>\n";
			stringToSendToWebBrowser += "                <a class=\"pull-right\" href=\"#\"><img class=\"media-object\" src=\"http://images.clipartbro.com/308/play-buttonpngoriginalpng-308152.png\" height=\"32\" width=\"32\"></a>\n";
			stringToSendToWebBrowser += "                <div class=\"media-body\">\n";
			stringToSendToWebBrowser += "                  <h4 class=\"Artist-Title\">" + playList.get(0).title
					+ " - " + playList.get(0).artist + "</h4>\n";
			stringToSendToWebBrowser += "                  <p>" + playList.get(0).tag + "</p>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </li>\n";
			stringToSendToWebBrowser += "              <li class=\"media\">\n";
			stringToSendToWebBrowser += "                <a class=\"pull-left\"><img class=\"media-object\" src=\"http://maxpixel.freegreatpicture.com/static/photo/1x/Symbol-Beamed-Note-Beams-Music-Notes-25705.png\" height=\"64\" width=\"64\"></a>\n";
			stringToSendToWebBrowser += "                <a class=\"pull-right\" href=\"#\"><img class=\"media-object\" src=\"http://images.clipartbro.com/308/play-buttonpngoriginalpng-308152.png\" height=\"32\" width=\"32\"></a>\n";
			stringToSendToWebBrowser += "                <div class=\"media-body\">\n";
			stringToSendToWebBrowser += "                  <h4 class=\"Artist-Title\">" + playList.get(1).title
					+ " - " + playList.get(1).artist + "</h4>\n";
			stringToSendToWebBrowser += "                  <p>" + playList.get(1).tag + "</p>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </li>\n";
			stringToSendToWebBrowser += "              <li class=\"media\">\n";
			stringToSendToWebBrowser += "                <a class=\"pull-left\"><img class=\"media-object\" src=\"http://maxpixel.freegreatpicture.com/static/photo/1x/Symbol-Beamed-Note-Beams-Music-Notes-25705.png\" height=\"64\" width=\"64\"></a>\n";
			stringToSendToWebBrowser += "                <a class=\"pull-right\" href=\"#\"><img class=\"media-object\" src=\"http://images.clipartbro.com/308/play-buttonpngoriginalpng-308152.png\" height=\"32\" width=\"32\"></a>\n";
			stringToSendToWebBrowser += "                <div class=\"media-body\">\n";
			stringToSendToWebBrowser += "                  <h4 class=\"Artist-Title\">" + playList.get(2).title
					+ " - " + playList.get(2).artist + "</h4>\n";
			stringToSendToWebBrowser += "                  <p>" + playList.get(2).tag + "</p>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </li>\n";
			stringToSendToWebBrowser += "              <li class=\"media\">\n";
			stringToSendToWebBrowser += "                <a class=\"pull-left\"><img class=\"media-object\" src=\"http://maxpixel.freegreatpicture.com/static/photo/1x/Symbol-Beamed-Note-Beams-Music-Notes-25705.png\" height=\"64\" width=\"64\"></a>\n";
			stringToSendToWebBrowser += "                <a class=\"pull-right\" href=\"#\"><img class=\"media-object\" src=\"http://images.clipartbro.com/308/play-buttonpngoriginalpng-308152.png\" height=\"32\" width=\"32\"></a>\n";
			stringToSendToWebBrowser += "                <div class=\"media-body\">\n";
			stringToSendToWebBrowser += "                  <h4 class=\"Artist-Title\">" + playList.get(3).title
					+ " - " + playList.get(3).artist + "</h4>\n";
			stringToSendToWebBrowser += "                  <p>" + playList.get(3).tag + "</p>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </li>\n";
			stringToSendToWebBrowser += "            </ul>\n";
			stringToSendToWebBrowser += "          </div=\"\">\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    <div class=\"section text-center\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row text-center\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-xs-3\">\n";
			stringToSendToWebBrowser += "            <a href=\"http://twitter.com\"><i class=\"fa fa-5x fa-fw fa-twitter\"></i></a>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "          <div class=\"col-xs-3\">\n";
			stringToSendToWebBrowser += "            <a href=\"http://facebook.com\"><i class=\"fa fa-5x fa-fw fa-facebook\"></i></a>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "          <a class=\"btn btn-lg btn-primary\" href=\"/LandingPage.html\">Search Again</a>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</body></html>\n";
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser);
			return true;
		
			
		}else if(toProcess.path.contains("ResultsPage.html")){
			System.out.println("error");
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<html><head>\n";
			stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "    <link href=\"http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "  </head><body>\n";
			stringToSendToWebBrowser += "<a href = \"/landingpage.html\">Back to Search</a>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</body></html>\n";
			toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser);
			return true;
			
		}return false;
		
	}

	private ArrayList<Song> getSongArray() {
		ArrayList<Song> songList = new ArrayList<Song>();
		
		Song song1 = new Song();
		song1.youtubeID = "FM7MFYoylVs";
		song1.artist = "The Chainsmokers & Coldplay";
		song1.title = "Something Just Like This";
		song1.tag = "Upbeat, Happy, Romantic";
		
		Song song2 = new Song();
		song2.youtubeID = "D5drYkLiLI8";
		song2.artist =  "Kygo, Selena Gomez";
		song2.title = "It Ain't Me";
		song2.tag = "Upbeat";
		
		Song song3 = new Song();
		song3.youtubeID = "JGwWNGJdvx8";
		song3.artist = "Ed Sheeran";
		song3.title = "Shape of You";
		song3.tag = "Upbeat, Happy";
		
		Song song4 = new Song();
		song4.youtubeID = "XatXy6ZhKZw";
		song4.artist = "Maroon 5";
		song4.title = "Cold ft. Future";
		song4.tag = "Upbeat, Deep";
		
		Song song5 = new Song();
		song5.youtubeID = "4N3N1MlvVc4";
		song5.artist = "Gary Jules";
		song5.title = "Mad World";
		song5.tag = "Sad, Deep";
		
		Song song6 = new Song();
		song6.youtubeID = "5rOiW_xY-kc";
		song6.artist = "REM";
		song6.title = "Everybody Hurts";
		song6.tag = "Sad, Deep";

		Song song7 = new Song();
		song7.youtubeID = "SmVAWKfJ4Go";
		song7.artist = "Johnny Cash";
		song7.title = "Hurt";
		song7.tag = "Sad, Deep";
		
		Song song8 = new Song();
		song8.youtubeID = "hLQl3WQQoQ0";
		song8.artist = "Adele";
		song8.title = "Someone Like You";
		song8.tag = "Sad, Deep";
		
		Song song9 = new Song();
		song9.youtubeID = "koJlIGDImiU";
		song9.artist = "Enrique Iglesias";
		song9.title = "Hero";
		song9.tag = "Romantic, Happy";
		
		Song song10 = new Song();
		song10.youtubeID =  "vGJTaP6anOU";
		song10.artist = "Elvis Presley";
		song10.title = "I Can't Help Falling in Love";
		song10.tag = "Romantic, Happy, Deep";
		
		Song song11 = new Song();
		song11.youtubeID =  "ZGoWtY_h4xo";
		song11.artist = "Bryan Adams";
		song11.title = "I Do It For You";
		song11.tag = "Romantic, Dreamy, Chill";
		
		Song song12 = new Song();
		song12.youtubeID = "Ss0kFNUP4P4";
		song12.artist = "Aerosmith";
		song12.title = "I Don't Wanna Miss A Thing";
		song12.tag = "Romantic, Dreamy";

		Song song13 = new Song();
		song13.youtubeID = "A6APxbBYnoo";
		song13.artist = "The All-American Rejects";
		song13.title = "Gives You Hell";
		song13.tag = "Angry, Upbeat";

		Song song14 = new Song();
		song14.youtubeID = "dQw4w9WgXcQ";
		song14.artist = "Rick Astley";
		song14.title = "Never Gonna Give You Up";
		song14.tag = "Upbeat, Romantic";

		Song song15 = new Song();
		song15.youtubeID = "KEI4qSrkPAs";
		song15.artist = "The Weeknd";
		song15.title = "Can't feel my face";
		song15.tag = "Upbeat, Romantic";

		Song song16 = new Song();
		song16.youtubeID = "psuRGfAaju4";
		song16.artist = "Owl City";
		song16.title = "Fireflies";
		song16.tag = "Dreamy, Chill";

		Song song17 = new Song();
		song17.youtubeID = "Mr1sqe_eZq4";
		song17.artist = "Matt Simons";
		song17.title = "Catch And Release";
		song17.tag = "Dreamy, Chill";

		Song song18 = new Song();
		song18.youtubeID = "GemKqzILV4w";
		song18.artist = "Snow Patrol";
		song18.title = "Chasing Cars";
		song18.tag = "Sad, Dreamy, Chill";

		Song song19 = new Song();
		song19.youtubeID = "bKxodgpyGec";
		song19.artist = "CeeLo Green";
		song19.title = "Forget You";
		song19.tag = "Angry, Chill";

		Song song20 = new Song();
		song20.youtubeID = "GemKqzILV4w";
		song20.artist = "Linkin Park";
		song20.title = "Numb";
		song20.tag = "Angry, Sad, Upbeat";

		Song song21 = new Song();
		song21.youtubeID = "GemKqzILV4w";
		song21.artist = "Avenged Sevenfold";
		song21.title = "Shepherd Of Fire";
		song21.tag = "Angry, Upbeat";

		Song song22 = new Song();
		song22.youtubeID = "jnslrTTXQSA";
		song22.artist = "Eminem";
		song22.title = "Till I collapse";
		song22.tag = "Upbeat, Angry";
	
		Song emptyResult = new Song();
		emptyResult.youtubeID = null;
		emptyResult.artist = "N/A";
		emptyResult.title = "N/A";
		emptyResult.tag = "N/A";

		// Set test data
		songList.add(emptyResult);
		songList.add(song1);
		songList.add(song2);
		songList.add(song3);
		songList.add(song4);
		songList.add(song5);
		songList.add(song6);
		songList.add(song7);
		songList.add(song8);
		songList.add(song9);
		songList.add(song10);
		songList.add(song11);
		songList.add(song12);	
		songList.add(song13);
		songList.add(song14);
		songList.add(song15);
		songList.add(song16);
		songList.add(song17);
		songList.add(song18);
		songList.add(song19);
		songList.add(song20);
		songList.add(song21);
		songList.add(song22);

		return songList;
	}

}