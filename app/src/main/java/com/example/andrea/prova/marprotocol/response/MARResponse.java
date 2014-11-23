package com.example.andrea.prova.marprotocol.response;

import org.xmlpull.v1.XmlPullParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andrea on 09/11/14.
 */



public abstract class MARResponse {

    protected XmlPullParser xml;

    protected static final String NO_CURRENT_TAG = "";
    protected static final String PARAMETER_NAME_TAG = "name";
    protected static final String PARAMETER_VALUE_TAG = "value";
    protected static final String PARAMETER_TAG = "member";
    protected static final Pattern INT_PATTERN = Pattern.compile("<int>(\\d+)</int>");
    protected static final Pattern STRING_PATTERN = Pattern.compile("<string>([^<])</string>");

    protected MARResponse(XmlPullParser xml) {
        this.xml = xml;
        GenerateResponse();
    }

    protected abstract void GenerateResponse();

    protected static int GetIntParameter(String parameterName, XmlPullParser xmlPullParser) {
        String val = GetParameterValue(parameterName, xmlPullParser);
        Matcher m = INT_PATTERN.matcher(val);
        if(m.find())
            return Integer.parseInt(m.group(1));
        else
            return -1;
    }

    protected static String GetStringParameter(String parameterName, XmlPullParser xmlPullParser) {
        String val = GetParameterValue(parameterName, xmlPullParser);
        Matcher m = STRING_PATTERN.matcher(val);
        if(m.find())
            return m.group(1);
        else
            return null;
    }

    protected static String GetParameterValue(String parameterName, XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            String currentTag =  MARResponse.NO_CURRENT_TAG;;
            String currentText;
            boolean skipParameter = false;
            boolean parameterFound = false;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTag = xmlPullParser.getName();
                        if (parameterFound && currentTag.equals(MARResponse.PARAMETER_VALUE_TAG))
                            return xmlPullParser.getText();
                        break;
                    case XmlPullParser.TEXT:
                        if (!skipParameter) {
                            currentText = xmlPullParser.getText();
                            if (currentTag.equals(MARResponse.PARAMETER_NAME_TAG)) {
                                if (!currentText.equals(parameterName))
                                    skipParameter = true;
                                else
                                    parameterFound = true;
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        currentTag = MARResponse.NO_CURRENT_TAG;
                        if(currentTag.equals(MARResponse.PARAMETER_TAG))
                            skipParameter = false;
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        }
        catch (Exception e)
        {}
        return null;
    }

}
