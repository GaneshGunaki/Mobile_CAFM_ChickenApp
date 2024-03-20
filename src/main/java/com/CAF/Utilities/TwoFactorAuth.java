package com.CAF.Utilities;

import org.jboss.aerogear.security.otp.Totp;
import org.testng.annotations.Parameters;

public class TwoFactorAuth {

//	@Parameters({"CountryName"})
	public String otpGenerator()
	{

		String securityKeyValue = ExcelDataTable.getExcelData("Sheet1", "SecurityKey", ExcelDataTable.columnName);
//		String securityKey= "2y6vprmttv57ytbb";
		Totp otp = new Totp(securityKeyValue);//RMX1851
		String twoFactorCode= otp.now();
		//TestUtility.Delay(2000);
		return twoFactorCode;

	}

}
