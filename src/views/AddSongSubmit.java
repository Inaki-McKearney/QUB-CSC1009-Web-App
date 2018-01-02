package views;

import org.h2.mvstore.MVMap;

import model.Song;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AddSongSubmit extends DynamicWebPage
{

	public AddSongSubmit(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}
	
	public boolean process(WebRequest toProcess)
	{
		
		Song song = new Song();
		song.artist = toProcess.params.get("artist");
		song.title = toProcess.params.get("songName");
		song.tag = toProcess.params.get("tag");
		song.youtubeID = toProcess.params.get("youTubeID");
		
		MVMap<String, Song> songsMap = db.s.openMap("Songs");
		
		
		songsMap.put(song.youtubeID, song);
		db.commit();
		
		if(toProcess.path.equalsIgnoreCase("AddSongSubmit.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "  <head>\n";
			stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\"\n";
			stringToSendToWebBrowser += "    rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "    <link href=\"http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css\"\n";
			stringToSendToWebBrowser += "    rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "  </head>\n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "  <body>\n";
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
			stringToSendToWebBrowser += "            <h1>Song Added!</h1>\n";
			stringToSendToWebBrowser += "            <p>Artist:"+song.artist+"</p>\n";
			stringToSendToWebBrowser += "            <p>Title:"+song.title+"</p>\n";
			stringToSendToWebBrowser += "            <p>Tag:"+song.tag+"</p>\n";
			stringToSendToWebBrowser += "            <p>YouTubeID:"+song.youtubeID+"</p>\n";
			stringToSendToWebBrowser += "            <p>\n";
			stringToSendToWebBrowser += "              <a href=\"landingpage.html\"> Back to Search!</a>\n";
			stringToSendToWebBrowser += "            </p>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		return false;
	}

}
