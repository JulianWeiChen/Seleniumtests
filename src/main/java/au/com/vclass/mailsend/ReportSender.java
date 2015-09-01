package au.com.vclass.mailsend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import main.java.au.com.vclass.mailmodule.constant.MailConstants;
import main.java.au.com.vclass.mailmodule.entity.MailSenderEntity;
import main.java.au.com.vclass.mailmodule.sender.CommonMailSender;

public class ReportSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Send email to developers
		String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMdd");
		time = formatter.format(date);

		String sub = "Daily Auto Test Report - " + time;
		String[] to = new String[] { "petri@vclass.com.au","julian@vclass.com.au" };
		HashMap<String, String> attMap = new HashMap<String, String>();
		attMap.put("./testreport/SignInTest-" + time + ".html", "SignInTest-"
				+ time + ".html");
		MailSenderEntity mailSendEntity = new MailSenderEntity();
		mailSendEntity.setMailServerHost(MailConstants.EMAIL_SERVER_HOST);
		mailSendEntity.setMailServerPort(MailConstants.EMAIL_SERVER_PORT);
		mailSendEntity.setUserName(MailConstants.EMAIL_ACCOUNT_NAME);
		mailSendEntity.setPassword(MailConstants.EMAIL_ACCOUNT_PWD);
		mailSendEntity.setValidate(true);
		mailSendEntity.setSendFrom(MailConstants.EMAIL_FROM);
		mailSendEntity.setSendTo(to);
		mailSendEntity.setSubject(sub);
		mailSendEntity.setAttachFiles(attMap);
//		String filePath = "./testreport/SignInTest-" + time + ".html";
//		try {
//			FileReader fr = new FileReader(filePath);
//			BufferedReader br = new BufferedReader(fr);
//			StringBuffer sb = new StringBuffer();
//			String line;
//			while ((line = br.readLine()) != null) {
//				//sb.append(line + "<br>");
//				sb.append(line);
//			}
//			br.close();
//			String content = sb.toString();
//			mailSendEntity.setContent(content);
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
		mailSendEntity.setContent("Please find today's test report from attachment. Thank you!");
		System.out.println(CommonMailSender.sendHtmlMail(mailSendEntity));
	}
	

}
