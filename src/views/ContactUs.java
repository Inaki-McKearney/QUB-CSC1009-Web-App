package views;

import model.Genre;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class ContactUs extends DynamicWebPage
{

	public ContactUs(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("ContactUs.html"))
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
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
			stringToSendToWebBrowser += "            <ul class=\"nav nav-justified nav-pills\">\n";
			stringToSendToWebBrowser += "              <li>\n";
			stringToSendToWebBrowser += "                <a href=\"LandingPage.html\">Home</a>\n";
			stringToSendToWebBrowser += "              </li>\n";
			stringToSendToWebBrowser += "              <li>\n";
			stringToSendToWebBrowser += "                <a href=\"ContactUs.html\">Contact Us</a>\n";
			stringToSendToWebBrowser += "              </li>\n";
			//removed personal page link - accessed through form
			stringToSendToWebBrowser += "            </ul>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			
			//Personal Page Log in form
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-10 text-center\">\n";
			stringToSendToWebBrowser += "            <h1 class=\"text-primary\">\n";
			stringToSendToWebBrowser += "              <b>Contact Us</b>\n";
			stringToSendToWebBrowser += "            </h1>\n";
			stringToSendToWebBrowser += "            <form class=\"text-right\" role=\"form\" action = \"/personalpage.html\" method = \"get\">\n";
			stringToSendToWebBrowser += "              <div class=\"imgcontainer\"></div>\n";
			stringToSendToWebBrowser += "				<p> Personal Page Log in </p>\n";
			stringToSendToWebBrowser += "              <label>\n";
			stringToSendToWebBrowser += "                <b>Username</b>\n";
			stringToSendToWebBrowser += "              </label>\n";
			stringToSendToWebBrowser += "                  <input type=\"email\" class=\"form-control\" id=\"userEmail\" placeholder=\"Email\" name = \"userEmail\">\n";
			stringToSendToWebBrowser += "              <br>\n";
			stringToSendToWebBrowser += "              <label>\n";
			stringToSendToWebBrowser += "                <b>Password</b>\n";
			stringToSendToWebBrowser += "              </label>\n";
			stringToSendToWebBrowser += "                  <input type=\"password\" class=\"form-control\" id=\"userPassword\" placeholder=\"Password\" name = \"userPassword\">\n";
			stringToSendToWebBrowser += "              <br>\n";
			stringToSendToWebBrowser += "                    <button type=\"submit\" class=\"btn btn-default\">Sign in</button>\n";
			stringToSendToWebBrowser += "            </form>\n";
			stringToSendToWebBrowser += "            <br>\n";
			stringToSendToWebBrowser += "            <br>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			//stringToSendToWebBrowser += "            <h1></h1>\n";   //changed title to the one above the form
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-3\">\n";
			stringToSendToWebBrowser += "            <h1 class=\"text-center\">Send us a message</h1>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-7\">\n";
			stringToSendToWebBrowser += "            <form role=\"form\">\n";
			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
			stringToSendToWebBrowser += "                <div class=\"input-group\">\n";
			stringToSendToWebBrowser += "                  <input type=\"text\" class=\"form-control\" placeholder=\"Enter your message\">\n";
			stringToSendToWebBrowser += "                  <span class=\"input-group-btn\">\n";
			stringToSendToWebBrowser += "                    <a class=\"btn btn-success\" type=\"submit\">Go</a>\n";
			stringToSendToWebBrowser += "                  </span>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "            </form>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-2\"></div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-offset-3 col-md-6\"></div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\"></div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "        <div class=\"row\"></div>\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-3\">\n";
			stringToSendToWebBrowser += "            <h1 class=\"text-center\">Leave us your email for us to get back to you</h1>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-9\">\n";
			stringToSendToWebBrowser += "            <form role=\"form\">\n";
			stringToSendToWebBrowser += "              <div class=\"form-group\">\n";
			stringToSendToWebBrowser += "                <div class=\"input-group\">\n";
			stringToSendToWebBrowser += "                  <input type=\"text\" class=\"form-control\" placeholder=\"Enter your email\">\n";
			stringToSendToWebBrowser += "                  <span class=\"input-group-btn\">\n";
			stringToSendToWebBrowser += "                    <a class=\"btn btn-success\" type=\"submit\">Go</a>\n";
			stringToSendToWebBrowser += "                  </span>\n";
			stringToSendToWebBrowser += "                </div>\n";
			stringToSendToWebBrowser += "              </div>\n";
			stringToSendToWebBrowser += "            </form>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-offset-3 col-md-6\"></div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\"></div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "    <div class=\"cover\">\n";
			stringToSendToWebBrowser += "      <div class=\"cover-image\"></div>\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12 text-center\">\n";
			stringToSendToWebBrowser += "            <br>\n";
			stringToSendToWebBrowser += "            <br>\n";
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