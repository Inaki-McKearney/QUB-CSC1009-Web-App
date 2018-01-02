package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class LandingPage extends DynamicWebPage
{

	public LandingPage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("LandingPage.html"))
		{
			String stringToSendToWebBrowser = "";
			//header
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
			
			//title
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
			stringToSendToWebBrowser += "            <h1>Mood Music</h1>\n";
			stringToSendToWebBrowser += "            <p>Music for your Mood!</p>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			
			//form container
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
			
			//form
			stringToSendToWebBrowser += "            <p><form class=\"form-horizontal\" role=\"form\" action = \"/personalpage.html\" method = \"get\">\n";
			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
			stringToSendToWebBrowser += "                <div class=\"col-sm-2\">\n";
			stringToSendToWebBrowser += "                  <label for=\"inputEmail3\" class=\"control-label\">Email</label>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "                <div class=\"col-sm-10\">\n";
			stringToSendToWebBrowser += "                  <input type=\"email\" class=\"form-control\" id=\"userEmail\" placeholder=\"Email\" name = \"userEmail\">\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
			stringToSendToWebBrowser += "                <div class=\"col-sm-2\">\n";
			stringToSendToWebBrowser += "                  <label for=\"inputPassword3\" class=\"control-label\">Password</label>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "                <div class=\"col-sm-10\">\n";
			stringToSendToWebBrowser += "                  <input type=\"password\" class=\"form-control\" id=\"userPassword\" placeholder=\"Password\" name = \"userPassword\">\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
			stringToSendToWebBrowser += "                <div class=\"form-group\">\n";
			stringToSendToWebBrowser += "                  <div class=\"col-sm-offset-2 col-sm-10\">\n";
			stringToSendToWebBrowser += "                    <button type=\"submit\" class=\"btn btn-default\">Sign in</button>\n";
			
			stringToSendToWebBrowser += "            </form>\n";
			//close form
			
			
			//sign up link
			stringToSendToWebBrowser += "	<form class=\"form-horizontal\" role=\"form\" action=\"/SignUpPage.html\" method =\"get\">\n";
			stringToSendToWebBrowser += "	<button type=\"submit\" class=\"btn btn-default\">Sign up</button> \n";
			stringToSendToWebBrowser += " 	</form></p>\n";
			
			stringToSendToWebBrowser += "                  </div>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </div>\n";
			
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			//close form
			
//			//results page form container
			stringToSendToWebBrowser += "	<div class=\"section\"> \n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
			stringToSendToWebBrowser += "            <div class=\"btn-group btn-group-lg\">\n";
			stringToSendToWebBrowser += "              <a class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\"> Choose a mood! <span class=\"fa fa-caret-down\"></span></a>\n";
			stringToSendToWebBrowser += "              <ul class=\"dropdown-menu\" role=\"menu\">\n";
			stringToSendToWebBrowser += "                \n";
			
						
//			//results page form
			//Changed tags - INAKI
			stringToSendToWebBrowser += "	<button><a href = \"Resultspage.html/angry\"> Angry </a>\n";
			stringToSendToWebBrowser += "	<button><a href = \"Resultspage.html/chill\"> Chill </a>\n";
			stringToSendToWebBrowser += "	<button><a href = \"Resultspage.html/deep\"> Deep </a>\n";
			stringToSendToWebBrowser += "	<button><a href = \"Resultspage.html/happy\"> Happy </a>\n";
			stringToSendToWebBrowser += "	<button><a href = \"Resultspage.html/romantic\"> Romantic </a>\n";
			stringToSendToWebBrowser += "	<button><a href = \"Resultspage.html/sad\"> Sad </a>\n";
			stringToSendToWebBrowser += "	<button><a href = \"Resultspage.html/upbeat\"> Upbeat </a>\n";
			stringToSendToWebBrowser += "              </ul>\n";
			stringToSendToWebBrowser += "            </div>\n";
//			//close form
			
			
//			//container for search bar
//			stringToSendToWebBrowser += "    <div class=\"section\">\n";
//			stringToSendToWebBrowser += "      <div class=\"container\">\n";
//			stringToSendToWebBrowser += "        <div class=\"row\">\n";
//			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
//			
//			
//			stringToSendToWebBrowser += "<form class=\"form-horizontal\" role=\"form\" action=\"/ResultsPage.html\" method=\"GET\">\n";
//			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
//			stringToSendToWebBrowser += "                <div class=\"col-sm-10\">\n";
//			stringToSendToWebBrowser += "                  <label for=\"inputTag3\" class=\"control-label\">Search</label>\n";
//			stringToSendToWebBrowser += "                </div>\n";
//			stringToSendToWebBrowser += "                <div class=\"col-sm-5\">\n";
//			stringToSendToWebBrowser += "                 <p> <input type=\"text\" class=\"form-control\" id=\"userTag\" placeholder=\"Enter Genre/Feeling\" name=\"userTag\"> <button type=\"submit\" class=\"btn btn-default\">Submit</button></p>\n";
//			stringToSendToWebBrowser += "                </div>\n";
//			
//			              
//			stringToSendToWebBrowser += "              </div>\n";
//			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
//			stringToSendToWebBrowser += "                \n";
//			stringToSendToWebBrowser += "                \n";
//			stringToSendToWebBrowser += "              </div>\n";
//			stringToSendToWebBrowser += "              <div class=\"form-group\"></div>\n";
//			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
//			
//			stringToSendToWebBrowser += "              </div>\n";
//			stringToSendToWebBrowser += "            </form>\n";
//			stringToSendToWebBrowser += "          </div>\n";
//			stringToSendToWebBrowser += "        </div>\n";
//			stringToSendToWebBrowser += "      </div>\n";
//			stringToSendToWebBrowser += "    </div>\n";
			
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			
			
			//contact us link
			stringToSendToWebBrowser += "                <div class=\"col-sm-offset-2 col-sm-10\">\n";
			stringToSendToWebBrowser += "            <p><a href = \"/ContactUs.html\">Contact Us<a/>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</html>\n";
			
			//end
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		return false;
	}
}