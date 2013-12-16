/**************************************************************************************************
  Filename:       HelpView.java
  Revised:        $Date: 2013-08-30 12:02:37 +0200 (fr, 30 aug 2013) $
  Revision:       $Revision: 27470 $

  Copyright 2013 Texas Instruments Incorporated. All rights reserved.
 
  IMPORTANT: Your use of this Software is limited to those specific rights
  granted under the terms of a software license agreement between the user
  who downloaded the software, his/her employer (which must be your employer)
  and Texas Instruments Incorporated (the "License").  You may not use this
  Software unless you agree to abide by the terms of the License. 
  The License limits your use, and you acknowledge, that the Software may not be 
  modified, copied or distributed unless used solely and exclusively in conjunction 
  with a Texas Instruments Bluetooth device. Other than for the foregoing purpose, 
  you may not use, reproduce, copy, prepare derivative works of, modify, distribute, 
  perform, display or sell this Software and/or its documentation for any purpose.
 
  YOU FURTHER ACKNOWLEDGE AND AGREE THAT THE SOFTWARE AND DOCUMENTATION ARE
  PROVIDED �AS IS" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS OR IMPLIED,
  INCLUDING WITHOUT LIMITATION, ANY WARRANTY OF MERCHANTABILITY, TITLE,
  NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT SHALL
  TEXAS INSTRUMENTS OR ITS LICENSORS BE LIABLE OR OBLIGATED UNDER CONTRACT,
  NEGLIGENCE, STRICT LIABILITY, CONTRIBUTION, BREACH OF WARRANTY, OR OTHER
  LEGAL EQUITABLE THEORY ANY DIRECT OR INDIRECT DAMAGES OR EXPENSES
  INCLUDING BUT NOT LIMITED TO ANY INCIDENTAL, SPECIAL, INDIRECT, PUNITIVE
  OR CONSEQUENTIAL DAMAGES, LOST PROFITS OR LOST DATA, COST OF PROCUREMENT
  OF SUBSTITUTE GOODS, TECHNOLOGY, SERVICES, OR ANY CLAIMS BY THIRD PARTIES
  (INCLUDING BUT NOT LIMITED TO ANY DEFENSE THEREOF), OR OTHER SIMILAR COSTS.
 
  Should you have any questions regarding your right to use this Software,
  contact Texas Instruments Incorporated at www.TI.com

 **************************************************************************************************/
package ti.android.ble.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class HelpView extends Fragment {
    private String mFile = "about.html";
    private int mIdFragment;
    private int mIdWebPage;

    private static final String KEY_FILE = "file";
    private static final String KEY_LAYOUT_RES = "frag_lay";
    private static final String KEY_WEB_PAGE = "id_web";

    public static HelpView newInstance(String file, int idFragment, int idWebpage) {
        HelpView f = new HelpView();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FILE, file);
        bundle.putInt(KEY_LAYOUT_RES, idFragment);
        bundle.putInt(KEY_WEB_PAGE, idWebpage);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFile = getArguments().getString(KEY_FILE);
        mIdFragment = getArguments().getInt(KEY_LAYOUT_RES);
        mIdWebPage = getArguments().getInt(KEY_WEB_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(mIdFragment, container, false);
        WebView wv = (WebView) rootView.findViewById(mIdWebPage);

        wv.loadUrl("file:///android_asset/" + mFile);
        return rootView;
    }

}
