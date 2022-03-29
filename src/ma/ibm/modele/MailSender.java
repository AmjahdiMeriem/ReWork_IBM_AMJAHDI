package ma.ibm.modele;

import java.time.LocalDate;
import java.util.Date;

import java.util.Properties;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;


import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;


public class MailSender {

	public MimeMessage sendMail(Demande demande) throws MessagingException {

		Properties props = new Properties();

		props.put("mail.smtp.host", "true");

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", "true");

		// Establishing a session with required user details

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("rework.ibm@gmail.com", "azerty@123");

			}

		});

		// Creating a Message object to set the email content

		MimeMessage msg = new MimeMessage(session);

		// Storing the comma seperated values to email addresses

		// String to =
		// demande.getCol().getPrenomCol()+"."+demande.getCol().getNomCol()+"@ibm.com";

		String to = "meriemamjahdi54@gmail.com";
		/*
		 * Parsing the String with defualt delimiter as a comma by marking the boolean
		 * as true and storing the email
		 * 
		 * addresses in an array of InternetAddress objects
		 */
		String htmlmsg = null;
		if(demande.getStatut().getIdStatut() == 850 || demande.getStatut().getIdStatut() == 950)
		{
			htmlmsg ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
					"<html xmlns:v=\"urn:schemas-microsoft-com:vml\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0;\" />\r\n" + 
					"    <meta name=\"viewport\" content=\"width=600,initial-scale = 2.3,user-scalable=no\">\r\n" + 
					"    <!--[if !mso]><!-- -->\r\n" + 
					"    <link href='https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,600,700' rel=\"stylesheet\">\r\n" + 
					"    <link href='https://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel=\"stylesheet\">\r\n" + 
					"    <!--<![endif]-->\r\n" + 
					"\r\n" + 
					"    <title>Material Design for Bootstrap</title>\r\n" + 
					"\r\n" + 
					"    <style type=\"text/css\">\r\n" + 
					"        body {\r\n" + 
					"            width: 100%;\r\n" + 
					"            background-color: #ffffff;\r\n" + 
					"            margin: 0;\r\n" + 
					"            padding: 0;\r\n" + 
					"            -webkit-font-smoothing: antialiased;\r\n" + 
					"            mso-margin-top-alt: 0px;\r\n" + 
					"            mso-margin-bottom-alt: 0px;\r\n" + 
					"            mso-padding-alt: 0px 0px 0px 0px;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        p,\r\n" + 
					"        h1,\r\n" + 
					"        h2,\r\n" + 
					"        h3,\r\n" + 
					"        h4 {\r\n" + 
					"            margin-top: 0;\r\n" + 
					"            margin-bottom: 0;\r\n" + 
					"            padding-top: 0;\r\n" + 
					"            padding-bottom: 0;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        span.preheader {\r\n" + 
					"            display: none;\r\n" + 
					"            font-size: 1px;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        html {\r\n" + 
					"            width: 100%;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        table {\r\n" + 
					"            font-size: 14px;\r\n" + 
					"            border: 0;\r\n" + 
					"        }\r\n" + 
					"        /* ----------- responsivity ----------- */\r\n" + 
					"\r\n" + 
					"        @media only screen and (max-width: 640px) {\r\n" + 
					"            /*------ top header ------ */\r\n" + 
					"            .main-header {\r\n" + 
					"                font-size: 20px !important;\r\n" + 
					"            }\r\n" + 
					"            .main-section-header {\r\n" + 
					"                font-size: 28px !important;\r\n" + 
					"            }\r\n" + 
					"            .show {\r\n" + 
					"                display: block !important;\r\n" + 
					"            }\r\n" + 
					"            .hide {\r\n" + 
					"                display: none !important;\r\n" + 
					"            }\r\n" + 
					"            .align-center {\r\n" + 
					"                text-align: center !important;\r\n" + 
					"            }\r\n" + 
					"            .no-bg {\r\n" + 
					"                background: none !important;\r\n" + 
					"            }\r\n" + 
					"            /*----- main image -------*/\r\n" + 
					"            .main-image img {\r\n" + 
					"                width: 440px !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"            /* ====== divider ====== */\r\n" + 
					"            .divider img {\r\n" + 
					"                width: 440px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- container --------*/\r\n" + 
					"            .container590 {\r\n" + 
					"                width: 440px !important;\r\n" + 
					"            }\r\n" + 
					"            .container580 {\r\n" + 
					"                width: 400px !important;\r\n" + 
					"            }\r\n" + 
					"            .main-button {\r\n" + 
					"                width: 220px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- secions ----------*/\r\n" + 
					"            .section-img img {\r\n" + 
					"                width: 320px !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"            .team-img img {\r\n" + 
					"                width: 100% !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        @media only screen and (max-width: 479px) {\r\n" + 
					"            /*------ top header ------ */\r\n" + 
					"            .main-header {\r\n" + 
					"                font-size: 18px !important;\r\n" + 
					"            }\r\n" + 
					"            .main-section-header {\r\n" + 
					"                font-size: 26px !important;\r\n" + 
					"            }\r\n" + 
					"            /* ====== divider ====== */\r\n" + 
					"            .divider img {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- container --------*/\r\n" + 
					"            .container590 {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"            }\r\n" + 
					"            .container590 {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"            }\r\n" + 
					"            .container580 {\r\n" + 
					"                width: 260px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- secions ----------*/\r\n" + 
					"            .section-img img {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"    </style>\r\n" + 
					"    <!--[if gte mso 9]><style type=”text/css”>\r\n" + 
					"        body {\r\n" + 
					"        font-family: arial, sans-serif!important;\r\n" + 
					"        }\r\n" + 
					"        </style>\r\n" + 
					"    <![endif]-->\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<body class=\"respond\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" + 
					"    <!-- pre-header -->\r\n" + 
					"    <table style=\"display:none!important;\">\r\n" + 
					"        <tr>\r\n" + 
					"            <td>\r\n" + 
					"                <div style=\"overflow:hidden;display:none;font-size:1px;color:#ffffff;line-height:1px;font-family:Arial;maxheight:0px;max-width:0px;opacity:0;\">\r\n" + 
					"                    Welcome to Re:Work!\r\n" + 
					"                </div>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"    </table>\r\n" + 
					"    <!-- pre-header end -->\r\n" + 
					"    <!-- header -->\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\">\r\n" + 
					"\r\n" + 
					"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\" height=\"70\" style=\"height:70px;\">\r\n" + 
					"                                        <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"100\" border=\"0\" style=\"display: block; width: 100%;\" src=\"https://i.ibb.co/B441HLG/Rework-wallpaper.png\" alt=\"\" /></a>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\">\r\n" + 
					"                                       \r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"    </table>\r\n" + 
					"    <!-- end header -->\r\n" + 
					"\r\n" + 
					"    <!-- big image section -->\r\n" + 
					"\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\" style=\"color: #343434; font-size: 24px; font-family: Quicksand, Calibri, sans-serif; font-weight:700;letter-spacing: 3px; line-height: 35px;\"\r\n" + 
					"                            class=\"main-header\">\r\n" + 
					"                            <!-- section text ======-->\r\n" + 
					"\r\n" + 
					"                            <div style=\"line-height: 35px\">\r\n" + 
					"\r\n" + 
					"                                Welcome to the future of <span style=\"color: #5caad2;\">Work</span>\r\n" + 
					"\r\n" + 
					"                            </div>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\">\r\n" + 
					"                            <table border=\"0\" width=\"40\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"eeeeee\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td height=\"2\" style=\"font-size: 2px; line-height: 2px;\">&nbsp;</td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"left\">\r\n" + 
					"                            <table border=\"0\" width=\"590\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"left\" style=\"color: #888888; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\r\n" + 
					"                                        <!-- section text ======-->\r\n" + 
					"\r\n" + 
					"                                        <p style=\"line-height: 24px; margin-bottom:15px;\">\r\n" + 
					"\r\n" + 
					"                                            Bonjour " + demande.getCol().getNomCol() + " "+demande.getCol().getPrenomCol()+",\r\n" + 
					"\r\n" + 
					"                                        </p>\r\n" + 
					"                                        <p style=\"line-height: 24px;margin-bottom:15px;\">\r\n" + 
					"                                            Votre demande de télétravail a été " +demande.getStatut().getLibelleStatut()+", cependant il vous est toujours possible de faire une demande de télétravail exceptionnelle à hauteur de 2 jours par mois ou bien\r\n" + 
					"                                    4 demi-journées.\r\n" + 
					"                                    </p>\r\n" + 
					"                                        <p style=\"line-height: 24px; margin-bottom:20px;\">\r\n" + 
					"                                            Nous vous rappelons qu'il est toujours possible de créer une nouvelle demande de télétravail récurrent ou bien une demande de télétravail exceptionnel (si votre solde le permet) à compter d'aujourd'hui.Votre solde actuel est de "+(4 - demande.getDuree())+" \r\n" + 
					"                                        </p>\r\n" + 
					"                                        \r\n" + 
					"                                        <p style=\"line-height: 24px\">\r\n" + 
					"                                            Cordialement,</br>\r\n" + 
					"                                            The ReWork Team\r\n" + 
					"                                        </p>\r\n" + 
					"\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                </table>\r\n" + 
					"\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"40\" style=\"font-size: 40px; line-height: 40px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"\r\n" + 
					"    <!-- end section -->\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    <!-- contact section -->\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\">\r\n" + 
					"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td>\r\n" + 
					"                                        <table border=\"0\" width=\"300\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                            class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <!-- logo -->\r\n" + 
					"                                                <td align=\"left\">\r\n" + 
					"                                                    <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"80\" border=\"0\" style=\"display: block; width: 80px;\" src=\"https://softwarereviews.s3.amazonaws.com/production/logos/offerings/3932/original/IBM_logo.png?1559150297\" alt=\"\" /></a>\r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td align=\"left\" style=\"color: #888888; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 23px;\"\r\n" + 
					"                                                    class=\"text_color\">\r\n" + 
					"                                                    <div style=\"color: #333333; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; font-weight: 600; mso-line-height-rule: exactly; line-height: 23px;\">\r\n" + 
					"\r\n" + 
					"                                                        Email us: <br/> <p style=\"color: #888888; font-size: 14px; font-family: 'Hind Siliguri', Calibri, Sans-serif; font-weight: 400;\">rework.ibm@gmail.com</p>\r\n" + 
					"\r\n" + 
					"                                                    </div>\r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                        </table>\r\n" + 
					"\r\n" + 
					"                                        <table border=\"0\" width=\"2\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                            class=\"container590\">\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td width=\"2\" height=\"10\" style=\"font-size: 10px; line-height: 10px;\"></td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                        </table>\r\n" + 
					"\r\n" + 
					"                                        <table border=\"0\" width=\"200\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                            class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td class=\"hide\" height=\"45\" style=\"font-size: 45px; line-height: 45px;\">&nbsp;</td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td height=\"15\" style=\"font-size: 15px; line-height: 15px;\">&nbsp;</td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td>\r\n" + 
					"                                                    <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
					"                                                        <tr>\r\n" + 
					"                                                            <td>\r\n" + 
					"                                                            \r\n" + 
					"                                                            </td>\r\n" + 
					"                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n" + 
					"                                                            <td>\r\n" + 
					"                                                                \r\n" + 
					"                                                            </td>\r\n" + 
					"                                                        </tr>\r\n" + 
					"                                                    </table>\r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                        </table>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"    <!-- end section -->\r\n" + 
					"\r\n" + 
					"    <!-- footer ====== -->\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"f4f4f4\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td>\r\n" + 
					"                            <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                class=\"container590\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"left\" style=\"color: #aaaaaa; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\r\n" + 
					"                                        <div style=\"line-height: 24px;\">\r\n" + 
					"\r\n" + 
					"                                      \r\n" + 
					"\r\n" + 
					"                                        </div>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"\r\n" + 
					"                            <table border=\"0\" align=\"left\" width=\"5\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                class=\"container590\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td height=\"20\" width=\"5\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"\r\n" + 
					"                            <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\">\r\n" + 
					"                                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td align=\"center\">\r\n" + 
					"                                                    <a style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;color: #5caad2; text-decoration: none;font-weight:bold;\">\r\n" + 
					"                                                        \r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                        </table>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"    <!-- end footer ====== -->\r\n" + 
					"\r\n" + 
					"<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script></body>\r\n" + 
					"\r\n" + 
					"</html>";
		}
		if(demande.getTypeDemande().getIdTypeDemande() == 2L && demande.getStatut().getIdStatut() == 800)
		{
			 htmlmsg = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
					"<html xmlns:v=\"urn:schemas-microsoft-com:vml\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0;\" />\r\n" + 
					"    <meta name=\"viewport\" content=\"width=600,initial-scale = 2.3,user-scalable=no\">\r\n" + 
					"    <!--[if !mso]><!-- -->\r\n" + 
					"    <link href='https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,600,700' rel=\"stylesheet\">\r\n" + 
					"    <link href='https://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel=\"stylesheet\">\r\n" + 
					"    <!--<![endif]-->\r\n" + 
					"\r\n" + 
					"    <title>Material Design for Bootstrap</title>\r\n" + 
					"\r\n" + 
					"    <style type=\"text/css\">\r\n" + 
					"        body {\r\n" + 
					"            width: 100%;\r\n" + 
					"            background-color: #ffffff;\r\n" + 
					"            margin: 0;\r\n" + 
					"            padding: 0;\r\n" + 
					"            -webkit-font-smoothing: antialiased;\r\n" + 
					"            mso-margin-top-alt: 0px;\r\n" + 
					"            mso-margin-bottom-alt: 0px;\r\n" + 
					"            mso-padding-alt: 0px 0px 0px 0px;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        p,\r\n" + 
					"        h1,\r\n" + 
					"        h2,\r\n" + 
					"        h3,\r\n" + 
					"        h4 {\r\n" + 
					"            margin-top: 0;\r\n" + 
					"            margin-bottom: 0;\r\n" + 
					"            padding-top: 0;\r\n" + 
					"            padding-bottom: 0;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        span.preheader {\r\n" + 
					"            display: none;\r\n" + 
					"            font-size: 1px;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        html {\r\n" + 
					"            width: 100%;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        table {\r\n" + 
					"            font-size: 14px;\r\n" + 
					"            border: 0;\r\n" + 
					"        }\r\n" + 
					"        /* ----------- responsivity ----------- */\r\n" + 
					"\r\n" + 
					"        @media only screen and (max-width: 640px) {\r\n" + 
					"            /*------ top header ------ */\r\n" + 
					"            .main-header {\r\n" + 
					"                font-size: 20px !important;\r\n" + 
					"            }\r\n" + 
					"            .main-section-header {\r\n" + 
					"                font-size: 28px !important;\r\n" + 
					"            }\r\n" + 
					"            .show {\r\n" + 
					"                display: block !important;\r\n" + 
					"            }\r\n" + 
					"            .hide {\r\n" + 
					"                display: none !important;\r\n" + 
					"            }\r\n" + 
					"            .align-center {\r\n" + 
					"                text-align: center !important;\r\n" + 
					"            }\r\n" + 
					"            .no-bg {\r\n" + 
					"                background: none !important;\r\n" + 
					"            }\r\n" + 
					"            /*----- main image -------*/\r\n" + 
					"            .main-image img {\r\n" + 
					"                width: 440px !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"            /* ====== divider ====== */\r\n" + 
					"            .divider img {\r\n" + 
					"                width: 440px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- container --------*/\r\n" + 
					"            .container590 {\r\n" + 
					"                width: 440px !important;\r\n" + 
					"            }\r\n" + 
					"            .container580 {\r\n" + 
					"                width: 400px !important;\r\n" + 
					"            }\r\n" + 
					"            .main-button {\r\n" + 
					"                width: 220px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- secions ----------*/\r\n" + 
					"            .section-img img {\r\n" + 
					"                width: 320px !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"            .team-img img {\r\n" + 
					"                width: 100% !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        @media only screen and (max-width: 479px) {\r\n" + 
					"            /*------ top header ------ */\r\n" + 
					"            .main-header {\r\n" + 
					"                font-size: 18px !important;\r\n" + 
					"            }\r\n" + 
					"            .main-section-header {\r\n" + 
					"                font-size: 26px !important;\r\n" + 
					"            }\r\n" + 
					"            /* ====== divider ====== */\r\n" + 
					"            .divider img {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- container --------*/\r\n" + 
					"            .container590 {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"            }\r\n" + 
					"            .container590 {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"            }\r\n" + 
					"            .container580 {\r\n" + 
					"                width: 260px !important;\r\n" + 
					"            }\r\n" + 
					"            /*-------- secions ----------*/\r\n" + 
					"            .section-img img {\r\n" + 
					"                width: 280px !important;\r\n" + 
					"                height: auto !important;\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"    </style>\r\n" + 
					"    <!--[if gte mso 9]><style type=”text/css”>\r\n" + 
					"        body {\r\n" + 
					"        font-family: arial, sans-serif!important;\r\n" + 
					"        }\r\n" + 
					"        </style>\r\n" + 
					"    <![endif]-->\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<body class=\"respond\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" + 
					"    <!-- pre-header -->\r\n" + 
					"    <table style=\"display:none!important;\">\r\n" + 
					"        <tr>\r\n" + 
					"            <td>\r\n" + 
					"                <div style=\"overflow:hidden;display:none;font-size:1px;color:#ffffff;line-height:1px;font-family:Arial;maxheight:0px;max-width:0px;opacity:0;\">\r\n" + 
					"                    Welcome to Re:Work!\r\n" + 
					"                </div>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"    </table>\r\n" + 
					"    <!-- pre-header end -->\r\n" + 
					"    <!-- header -->\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\">\r\n" + 
					"\r\n" + 
					"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\" height=\"70\" style=\"height:70px;\">\r\n" + 
					"                                        <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"100\" border=\"0\" style=\"display: block; width: 100px;\" src=\"https://softwarereviews.s3.amazonaws.com/production/logos/offerings/3932/original/IBM_logo.png?1559150297\" alt=\"\" /></a>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\">\r\n" + 
					"                                       \r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"    </table>\r\n" + 
					"    <!-- end header -->\r\n" + 
					"\r\n" + 
					"    <!-- big image section -->\r\n" + 
					"\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\" style=\"color: #343434; font-size: 24px; font-family: Quicksand, Calibri, sans-serif; font-weight:700;letter-spacing: 3px; line-height: 35px;\"\r\n" + 
					"                            class=\"main-header\">\r\n" + 
					"                            <!-- section text ======-->\r\n" + 
					"\r\n" + 
					"                            <div style=\"line-height: 35px\">\r\n" + 
					"\r\n" + 
					"                                Welcome to the future of <span style=\"color: #5caad2;\">Work</span>\r\n" + 
					"\r\n" + 
					"                            </div>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\">\r\n" + 
					"                            <table border=\"0\" width=\"40\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"eeeeee\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td height=\"2\" style=\"font-size: 2px; line-height: 2px;\">&nbsp;</td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"left\">\r\n" + 
					"                            <table border=\"0\" width=\"590\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"left\" style=\"color: #888888; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\r\n" + 
					"                                        <!-- section text ======-->\r\n" + 
					"\r\n" + 
					"                                        <p style=\"line-height: 24px; margin-bottom:15px;\">\r\n" + 
					"\r\n" + 
					"                                            Bonjour " + demande.getCol().getNomCol() + " "+demande.getCol().getPrenomCol()+",\r\n" + 
					"\r\n" + 
					"                                        </p>\r\n" + 
					"                                        <p style=\"line-height: 24px;margin-bottom:15px;\">\r\n" + 
					"                                            Bonne nouvelle, votre demande de télétravail exceptionnelle du "+ demande.getDateEx1()+ " a été accepté ! Vous pouvez travailler à distance le"+ demande.getJourTele() + " \r\n" + 
					"                                        </p>\r\n" + 
					"                                        <p style=\"line-height: 24px; margin-bottom:20px;\">\r\n" + 
					"                                            Nous vous rappelons qu'il vous reste " + (4- demande.getDuree())+ " demi-journées avant la fin du mois en cours.\r\n" + 
					"                                        </p>\r\n" + 
					"                                        \r\n" + 
					"                                        <p style=\"line-height: 24px\">\r\n" + 
					"                                            Cordialement,</br>\r\n" + 
					"                                            The ReWork Team\r\n" + 
					"                                        </p>\r\n" + 
					"\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                </table>\r\n" + 
					"\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"40\" style=\"font-size: 40px; line-height: 40px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"\r\n" + 
					"    <!-- end section -->\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    <!-- main section -->\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"2a2e36\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td <a href=\"https://ibb.co/VHHK0Vx\"><img src=\"https://i.ibb.co/B441HLG/Rework-wallpaper.png\" alt=\"Rework-wallpaper\" border=\"0\"></a><br />\r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"50\" style=\"font-size: 50px; line-height: 50px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\">\r\n" + 
					"                            <table border=\"0\" width=\"380\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\">\r\n" + 
					"                                        <table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container580\">\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td align=\"center\" style=\"color: #cccccc; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 26px;\">\r\n" + 
					"                                                    <!-- section text ======-->\r\n" + 
					"\r\n" + 
					"                                                    <div style=\"line-height: 26px\">\r\n" + 
					"\r\n" + 
					"                                                    </div>\r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                        </table>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td height=\"50\" style=\"font-size: 50px; line-height: 50px;\">&nbsp;</td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"\r\n" + 
					"    <!-- end section -->\r\n" + 
					"\r\n" + 
					"    <!-- contact section -->\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\">\r\n" + 
					"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td>\r\n" + 
					"                                        <table border=\"0\" width=\"300\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                            class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <!-- logo -->\r\n" + 
					"                                                <td align=\"left\">\r\n" + 
					"                                                    <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"80\" border=\"0\" style=\"display: block; width: 80px;\" src=\"https://softwarereviews.s3.amazonaws.com/production/logos/offerings/3932/original/IBM_logo.png?1559150297\" alt=\"\" /></a>\r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td align=\"left\" style=\"color: #888888; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 23px;\"\r\n" + 
					"                                                    class=\"text_color\">\r\n" + 
					"                                                    <div style=\"color: #333333; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; font-weight: 600; mso-line-height-rule: exactly; line-height: 23px;\">\r\n" + 
					"\r\n" + 
					"                                                        Email us: <br/> <p style=\"color: #888888; font-size: 14px; font-family: 'Hind Siliguri', Calibri, Sans-serif; font-weight: 400;\">rework.ibm@gmail.com</p>\r\n" + 
					"\r\n" + 
					"                                                    </div>\r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                        </table>\r\n" + 
					"\r\n" + 
					"                                        <table border=\"0\" width=\"2\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                            class=\"container590\">\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td width=\"2\" height=\"10\" style=\"font-size: 10px; line-height: 10px;\"></td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                        </table>\r\n" + 
					"\r\n" + 
					"                                        <table border=\"0\" width=\"200\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                            class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td class=\"hide\" height=\"45\" style=\"font-size: 45px; line-height: 45px;\">&nbsp;</td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td height=\"15\" style=\"font-size: 15px; line-height: 15px;\">&nbsp;</td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td>\r\n" + 
					"                                                    <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
					"                                                        <tr>\r\n" + 
					"                                                            <td>\r\n" + 
					"                                                            \r\n" + 
					"                                                            </td>\r\n" + 
					"                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n" + 
					"                                                            <td>\r\n" + 
					"                                                                \r\n" + 
					"                                                            </td>\r\n" + 
					"                                                        </tr>\r\n" + 
					"                                                    </table>\r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"\r\n" + 
					"                                        </table>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"    <!-- end section -->\r\n" + 
					"\r\n" + 
					"    <!-- footer ====== -->\r\n" + 
					"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"f4f4f4\">\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\">\r\n" + 
					"\r\n" + 
					"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
					"\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td>\r\n" + 
					"                            <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                class=\"container590\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"left\" style=\"color: #aaaaaa; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\r\n" + 
					"                                        <div style=\"line-height: 24px;\">\r\n" + 
					"\r\n" + 
					"                                      \r\n" + 
					"\r\n" + 
					"                                        </div>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"\r\n" + 
					"                            <table border=\"0\" align=\"left\" width=\"5\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                class=\"container590\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td height=\"20\" width=\"5\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"\r\n" + 
					"                            <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
					"                                class=\"container590\">\r\n" + 
					"\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\">\r\n" + 
					"                                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td align=\"center\">\r\n" + 
					"                                                    <a style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;color: #5caad2; text-decoration: none;font-weight:bold;\"\r\n" + 
					"                                                        \r\n" + 
					"                                                </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                        </table>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"        <tr>\r\n" + 
					"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
					"        </tr>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"    <!-- end footer ====== -->\r\n" + 
					"\r\n" + 
					"<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script></body>\r\n" + 
					"\r\n" + 
					"</html>";
		}
		if(demande.getStatut().getIdStatut() == 900L) {
		htmlmsg = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns:v=\"urn:schemas-microsoft-com:vml\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0;\" />\r\n" + 
				"    <meta name=\"viewport\" content=\"width=600,initial-scale = 2.3,user-scalable=no\">\r\n" + 
				"    <!--[if !mso]><!-- -->\r\n" + 
				"    <link href='https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,600,700' rel=\"stylesheet\">\r\n" + 
				"    <link href='https://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel=\"stylesheet\">\r\n" + 
				"    <!--<![endif]-->\r\n" + 
				"\r\n" + 
				"    <title>Material Design for Bootstrap</title>\r\n" + 
				"\r\n" + 
				"    <style type=\"text/css\">\r\n" + 
				"        body {\r\n" + 
				"            width: 100%;\r\n" + 
				"            background-color: #ffffff;\r\n" + 
				"            margin: 0;\r\n" + 
				"            padding: 0;\r\n" + 
				"            -webkit-font-smoothing: antialiased;\r\n" + 
				"            mso-margin-top-alt: 0px;\r\n" + 
				"            mso-margin-bottom-alt: 0px;\r\n" + 
				"            mso-padding-alt: 0px 0px 0px 0px;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        p,\r\n" + 
				"        h1,\r\n" + 
				"        h2,\r\n" + 
				"        h3,\r\n" + 
				"        h4 {\r\n" + 
				"            margin-top: 0;\r\n" + 
				"            margin-bottom: 0;\r\n" + 
				"            padding-top: 0;\r\n" + 
				"            padding-bottom: 0;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        span.preheader {\r\n" + 
				"            display: none;\r\n" + 
				"            font-size: 1px;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        html {\r\n" + 
				"            width: 100%;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        table {\r\n" + 
				"            font-size: 14px;\r\n" + 
				"            border: 0;\r\n" + 
				"        }\r\n" + 
				"        /* ----------- responsivity ----------- */\r\n" + 
				"\r\n" + 
				"        @media only screen and (max-width: 640px) {\r\n" + 
				"            /*------ top header ------ */\r\n" + 
				"            .main-header {\r\n" + 
				"                font-size: 20px !important;\r\n" + 
				"            }\r\n" + 
				"            .main-section-header {\r\n" + 
				"                font-size: 28px !important;\r\n" + 
				"            }\r\n" + 
				"            .show {\r\n" + 
				"                display: block !important;\r\n" + 
				"            }\r\n" + 
				"            .hide {\r\n" + 
				"                display: none !important;\r\n" + 
				"            }\r\n" + 
				"            .align-center {\r\n" + 
				"                text-align: center !important;\r\n" + 
				"            }\r\n" + 
				"            .no-bg {\r\n" + 
				"                background: none !important;\r\n" + 
				"            }\r\n" + 
				"            /*----- main image -------*/\r\n" + 
				"            .main-image img {\r\n" + 
				"                width: 440px !important;\r\n" + 
				"                height: auto !important;\r\n" + 
				"            }\r\n" + 
				"            /* ====== divider ====== */\r\n" + 
				"            .divider img {\r\n" + 
				"                width: 440px !important;\r\n" + 
				"            }\r\n" + 
				"            /*-------- container --------*/\r\n" + 
				"            .container590 {\r\n" + 
				"                width: 440px !important;\r\n" + 
				"            }\r\n" + 
				"            .container580 {\r\n" + 
				"                width: 400px !important;\r\n" + 
				"            }\r\n" + 
				"            .main-button {\r\n" + 
				"                width: 220px !important;\r\n" + 
				"            }\r\n" + 
				"            /*-------- secions ----------*/\r\n" + 
				"            .section-img img {\r\n" + 
				"                width: 320px !important;\r\n" + 
				"                height: auto !important;\r\n" + 
				"            }\r\n" + 
				"            .team-img img {\r\n" + 
				"                width: 100% !important;\r\n" + 
				"                height: auto !important;\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        @media only screen and (max-width: 479px) {\r\n" + 
				"            /*------ top header ------ */\r\n" + 
				"            .main-header {\r\n" + 
				"                font-size: 18px !important;\r\n" + 
				"            }\r\n" + 
				"            .main-section-header {\r\n" + 
				"                font-size: 26px !important;\r\n" + 
				"            }\r\n" + 
				"            /* ====== divider ====== */\r\n" + 
				"            .divider img {\r\n" + 
				"                width: 280px !important;\r\n" + 
				"            }\r\n" + 
				"            /*-------- container --------*/\r\n" + 
				"            .container590 {\r\n" + 
				"                width: 280px !important;\r\n" + 
				"            }\r\n" + 
				"            .container590 {\r\n" + 
				"                width: 280px !important;\r\n" + 
				"            }\r\n" + 
				"            .container580 {\r\n" + 
				"                width: 260px !important;\r\n" + 
				"            }\r\n" + 
				"            /*-------- secions ----------*/\r\n" + 
				"            .section-img img {\r\n" + 
				"                width: 280px !important;\r\n" + 
				"                height: auto !important;\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    </style>\r\n" + 
				"    <!--[if gte mso 9]><style type=”text/css”>\r\n" + 
				"        body {\r\n" + 
				"        font-family: arial, sans-serif!important;\r\n" + 
				"        }\r\n" + 
				"        </style>\r\n" + 
				"    <![endif]-->\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<body class=\"respond\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" + 
				"    <!-- pre-header -->\r\n" + 
				"    <table style=\"display:none!important;\">\r\n" + 
				"        <tr>\r\n" + 
				"            <td>\r\n" + 
				"                <div style=\"overflow:hidden;display:none;font-size:1px;color:#ffffff;line-height:1px;font-family:Arial;maxheight:0px;max-width:0px;opacity:0;\">\r\n" + 
				"                    Re:Work!\r\n" + 
				"                </div>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>\r\n" + 
				"    <!-- pre-header end -->\r\n" + 
				"    <!-- header -->\r\n" + 
				"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\">\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"center\">\r\n" + 
				"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td align=\"center\">\r\n" + 
				"\r\n" + 
				"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
				"\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td align=\"center\" height=\"70\" style=\"height:70px;\">\r\n" + 
				"                                        <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"100\" border=\"0\" style=\"display: block; width: 100%;\" src=\"https://i.ibb.co/B441HLG/Rework-wallpaper.png\" alt=\"\" /></a>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td align=\"center\">\r\n" + 
				"                                       \r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                </table>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>\r\n" + 
				"    <!-- end header -->\r\n" + 
				"\r\n" + 
				"    <!-- big image section -->\r\n" + 
				"\r\n" + 
				"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"center\">\r\n" + 
				"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td align=\"center\" style=\"color: #343434; font-size: 24px; font-family: Quicksand, Calibri, sans-serif; font-weight:700;letter-spacing: 3px; line-height: 35px;\"\r\n" + 
				"                            class=\"main-header\">\r\n" + 
				"                            <!-- section text ======-->\r\n" + 
				"\r\n" + 
				"                            <div style=\"line-height: 35px\">\r\n" + 
				"\r\n" + 
				"                                Welcome to the future of <span style=\"color: #5caad2;\">Work</span>\r\n" + 
				"\r\n" + 
				"                            </div>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td align=\"center\">\r\n" + 
				"                            <table border=\"0\" width=\"40\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"eeeeee\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td height=\"2\" style=\"font-size: 2px; line-height: 2px;\">&nbsp;</td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td align=\"left\">\r\n" + 
				"                            <table border=\"0\" width=\"590\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td align=\"left\" style=\"color: #888888; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\r\n" + 
				"                                        <!-- section text ======-->\r\n" + 
				"\r\n" + 
				"                                        <p style=\"line-height: 24px; margin-bottom:15px;\">\r\n" + 
				"\r\n" + 
				"                                            Bonjour " + demande.getCol().getNomCol() + " "+demande.getCol().getPrenomCol()+",\r\n" + 
				"\r\n" + 
				"                                        </p>\r\n" + 
				"                                        <p style=\"line-height: 24px;margin-bottom:15px;\">\r\n" + 
				"                                            Bonne nouvelle, votre demande de télétravail a été accepté, maintenant vous pouvez travailler à distance chaque"+ demande.getJourTele() + " \r\n" + 
				"                                        </p>\r\n" + 
				"                                        <p style=\"line-height: 24px; margin-bottom:20px;\">\r\n" + 
				"                                            Nous vous rappelons que la demande est valable jusqu'au "+ LocalDate.now().plusDays(90) +".\r\n" + 
				"                                        </p>\r\n" + 
				"                                        \r\n" + 
				"                                        <p style=\"line-height: 24px\">\r\n" + 
				"                                            Cordialement,</br>\r\n" + 
				"                                            The ReWork Team\r\n" + 
				"                                        </p>\r\n" + 
				"\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                </table>\r\n" + 
				"\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td height=\"40\" style=\"font-size: 40px; line-height: 40px;\">&nbsp;</td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"    </table>\r\n" + 
				"\r\n" + 
				"    <!-- end section -->\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <!-- contact section -->\r\n" + 
				"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"center\">\r\n" + 
				"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td align=\"center\">\r\n" + 
				"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\r\n" + 
				"\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td>\r\n" + 
				"                                        <table border=\"0\" width=\"300\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
				"                                            class=\"container590\">\r\n" + 
				"\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <!-- logo -->\r\n" + 
				"                                                <td align=\"left\">\r\n" + 
				"                                                    <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"80\" border=\"0\" style=\"display: block; width: 80px;\" src=\"https://softwarereviews.s3.amazonaws.com/production/logos/offerings/3932/original/IBM_logo.png?1559150297\" alt=\"\" /></a>\r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
				"                                            </tr>\r\n" + 
				"\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td align=\"left\" style=\"color: #888888; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 23px;\"\r\n" + 
				"                                                    class=\"text_color\">\r\n" + 
				"                                                    <div style=\"color: #333333; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; font-weight: 600; mso-line-height-rule: exactly; line-height: 23px;\">\r\n" + 
				"\r\n" + 
				"                                                        Email us: <br/> <p style=\"color: #888888; font-size: 14px; font-family: 'Hind Siliguri', Calibri, Sans-serif; font-weight: 400;\">rework.ibm@gmail.com</p>\r\n" + 
				"\r\n" + 
				"                                                    </div>\r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"\r\n" + 
				"                                        </table>\r\n" + 
				"\r\n" + 
				"                                        <table border=\"0\" width=\"2\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
				"                                            class=\"container590\">\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td width=\"2\" height=\"10\" style=\"font-size: 10px; line-height: 10px;\"></td>\r\n" + 
				"                                            </tr>\r\n" + 
				"                                        </table>\r\n" + 
				"\r\n" + 
				"                                        <table border=\"0\" width=\"200\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
				"                                            class=\"container590\">\r\n" + 
				"\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td class=\"hide\" height=\"45\" style=\"font-size: 45px; line-height: 45px;\">&nbsp;</td>\r\n" + 
				"                                            </tr>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td height=\"15\" style=\"font-size: 15px; line-height: 15px;\">&nbsp;</td>\r\n" + 
				"                                            </tr>\r\n" + 
				"\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td>\r\n" + 
				"                                                    <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"                                                        <tr>\r\n" + 
				"                                                            <td>\r\n" + 
				"                                                            \r\n" + 
				"                                                            </td>\r\n" + 
				"                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n" + 
				"                                                            <td>\r\n" + 
				"                                                                \r\n" + 
				"                                                            </td>\r\n" + 
				"                                                        </tr>\r\n" + 
				"                                                    </table>\r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                </table>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"    </table>\r\n" + 
				"    <!-- end section -->\r\n" + 
				"\r\n" + 
				"    <!-- footer ====== -->\r\n" + 
				"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"f4f4f4\">\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td align=\"center\">\r\n" + 
				"\r\n" + 
				"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\r\n" + 
				"\r\n" + 
				"                    <tr>\r\n" + 
				"                        <td>\r\n" + 
				"                            <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
				"                                class=\"container590\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td align=\"left\" style=\"color: #aaaaaa; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\r\n" + 
				"                                        <div style=\"line-height: 24px;\">\r\n" + 
				"\r\n" + 
				"                                      \r\n" + 
				"\r\n" + 
				"                                        </div>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"\r\n" + 
				"                            <table border=\"0\" align=\"left\" width=\"5\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
				"                                class=\"container590\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td height=\"20\" width=\"5\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </table>\r\n" + 
				"\r\n" + 
				"                            <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\r\n" + 
				"                                class=\"container590\">\r\n" + 
				"\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <td align=\"center\">\r\n" + 
				"                                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td align=\"center\">\r\n" + 
				"                                                    <a style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;color: #5caad2; text-decoration: none;font-weight:bold;\">\r\n" + 
				"                                                        \r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"\r\n" + 
				"                            </table>\r\n" + 
				"                        </td>\r\n" + 
				"                    </tr>\r\n" + 
				"\r\n" + 
				"                </table>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"        <tr>\r\n" + 
				"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\r\n" + 
				"        </tr>\r\n" + 
				"\r\n" + 
				"    </table>\r\n" + 
				"    <!-- end footer ====== -->\r\n" + 
				"\r\n" + 
				"<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script></body>\r\n" + 
				"\r\n" + 
				"</html>";
		}
		InternetAddress[] address = InternetAddress.parse(to, true);

		// Setting the recepients from the address variable

		msg.setRecipients(Message.RecipientType.TO, address);

		String timeStamp = LocalDate.now().toString();

		msg.setSubject("Demande télétravail : " + timeStamp);

		msg.setSentDate(new Date());

		msg.setContent(htmlmsg, "text/html");

		msg.setHeader("XPriority", "1");
		if(demande.getStatut().getIdStatut() == 800 && demande.getTypeDemande().getIdTypeDemande() == 1L)
		{
			msg = null;
		}
		return msg;
	}
}