package views;

import org.h2.mvstore.MVMap;

import model.UserInformation;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class PersonalPage extends DynamicWebPage
{

	public PersonalPage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		
		if(toProcess.path.equalsIgnoreCase("PersonalPage.html"))
		{	
			MVMap<String, UserInformation> users = db.s.openMap("Users");
			UserInformation user = users.get(toProcess.params.get("userEmail"));
			String x = toProcess.params.get("userEmail");
			
			if(users.containsKey(x)&&x!=null&&x.length()>0){
				
				if(user.userEmailAddress.equals(toProcess.params.get("userEmail"))
						&&user.userPassword.equals(toProcess.params.get("userPassword"))){
				
					String stringToSendToWebBrowser = "";
					stringToSendToWebBrowser += "<!DOCTYPE html>\n";
					stringToSendToWebBrowser += "<html>\n";
					stringToSendToWebBrowser += "  <head>\n";
					stringToSendToWebBrowser += "    <title>PersonalPage</title>\n";
					stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
					stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
					stringToSendToWebBrowser += "    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
					stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
					stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
					stringToSendToWebBrowser += "    <![endif]-->\n";
					stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
					stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
					stringToSendToWebBrowser += "  </head>\n";
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
					//deleted personal page link - accessed from log ins on results/front page
					stringToSendToWebBrowser += "            </ul>\n";
					stringToSendToWebBrowser += "          </div>\n";
					stringToSendToWebBrowser += "        </div>\n";
					stringToSendToWebBrowser += "            \n";
					stringToSendToWebBrowser += "          </div>\n";
					stringToSendToWebBrowser += "        </div>\n";
					stringToSendToWebBrowser += "      </div>\n";
					stringToSendToWebBrowser += "    </div>\n";
					stringToSendToWebBrowser += "    <h1>PersonalPage<h1>\n";
					stringToSendToWebBrowser += "    <p>" +user.userEmailAddress+"</p>\n";
					stringToSendToWebBrowser += "    <p>Signed In</p>\n";
					stringToSendToWebBrowser += "    <a href = \"AddSong.html\"> Add a Song! </a>\n"; 
					stringToSendToWebBrowser += "  </body>\n";
					stringToSendToWebBrowser += "</html>\n";
					toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
					return true;
				}else{
					String stringToSendToWebBrowser = "";
					stringToSendToWebBrowser += "<!DOCTYPE html>\n";
					stringToSendToWebBrowser += "<html>\n";
					stringToSendToWebBrowser += "  <head>\n";
					stringToSendToWebBrowser += "    <title>PersonalPage</title>\n";
					stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
					stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
					stringToSendToWebBrowser += "    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
					stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
					stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
					stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
					stringToSendToWebBrowser += "    <![endif]-->\n";
					stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
					stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
					stringToSendToWebBrowser += "  </head>\n";
					stringToSendToWebBrowser += "  <body>\n";
					stringToSendToWebBrowser += "    <h1>PersonalPage<h1>\n";
					stringToSendToWebBrowser += "    <p>Incorrect Password<p/>\n";
					stringToSendToWebBrowser += "    <p><a href =\"LandingPage.html\">Back to Login<a/><p/>\n";
					stringToSendToWebBrowser += "  </body>\n";
					stringToSendToWebBrowser += "</html>\n";
					toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
					return true;				
				}
			}else
			if(!users.containsKey(x)&&x.length()>0){
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <title>PersonalPage</title>\n";
				stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
				stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
				stringToSendToWebBrowser += "    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <![endif]-->\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "  <body>\n";
				stringToSendToWebBrowser += "  <p> Not Registered </a></p>";
				
				
				stringToSendToWebBrowser += "  <p><a href = \"signuppage.html\"> Sign Up Page </a></p>";
				stringToSendToWebBrowser += "  <p><a href = \"landingpage.html\"> Home Page/Log in </a></p>";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
				
				
			}else{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <title>PersonalPage</title>\n";
				stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
				stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
				stringToSendToWebBrowser += "    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <![endif]-->\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "  <body>\n";
				stringToSendToWebBrowser += "  <p> Invalid Entry </a></p>";
				
				
				stringToSendToWebBrowser += "  <p><a href = \"signuppage.html\"> Sign Up Page </a></p>";
				stringToSendToWebBrowser += "  <p><a href = \"landingpage.html\"> Home Page/Log in </a></p>";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
			}
			
		}
		return false;
		}

}