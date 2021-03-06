package org.michenux.yourappidea.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.michenux.android.ui.animation.LiveButton;
import org.michenux.android.ui.navdrawer.AbstractNavDrawerActivity;
import org.michenux.android.ui.navdrawer.NavDrawerSelectItemRunnable;
import org.michenux.yourappidea.R;
import org.michenux.yourappidea.YourApplication;

import javax.inject.Inject;

public class MainFragment extends Fragment {

    @Inject
    LiveButton liveButton ;

    private AdView mAdView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((YourApplication) getActivity().getApplication()).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mainView = inflater
                .inflate(R.layout.main_fragment, container, false);

        mAdView = (AdView) mainView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("1174B15820BDCDE357023377AAF1D72D")
                .addTestDevice("FB73634EFAFEF29BE7973A97B5543A4D")
                .addTestDevice("3C4438D5DE2E7086B63C92FC5846F662") //LG Nexus 5
                .build();
        mAdView.loadAd(adRequest);

        Button button0 = (Button) mainView.findViewById(R.id.mainmenu_button0);
        liveButton.setupLiveAnimOnButton(button0, new NavDrawerSelectItemRunnable((AbstractNavDrawerActivity)this.getActivity(), 1));

        Button button1 = (Button) mainView.findViewById(R.id.mainmenu_button1);
        liveButton.setupLiveAnimOnButton(button1, new NavDrawerSelectItemRunnable((AbstractNavDrawerActivity)this.getActivity(), 2));

        Button button2 = (Button) mainView.findViewById(R.id.mainmenu_button2);
        liveButton.setupLiveAnimOnButton(button2, new NavDrawerSelectItemRunnable((AbstractNavDrawerActivity)this.getActivity(), 3));

        Button button3 = (Button) mainView.findViewById(R.id.mainmenu_button3);
        liveButton.setupLiveAnimOnButton(button3, new NavDrawerSelectItemRunnable((AbstractNavDrawerActivity)this.getActivity(), 4));

        Button button4 = (Button) mainView.findViewById(R.id.mainmenu_button4);
        liveButton.setupLiveAnimOnButton(button4, new NavDrawerSelectItemRunnable((AbstractNavDrawerActivity)this.getActivity(), 5));

        return mainView;
    }

    @Override
    public void onPause() {
        super.onPause();
        mAdView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdView.resume();
    }

    @Override
    public void onDestroy() {
        mAdView.destroy();
        super.onDestroy();
    }
}
