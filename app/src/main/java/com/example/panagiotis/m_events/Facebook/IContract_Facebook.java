package com.example.panagiotis.m_events.Facebook;

import com.example.panagiotis.m_events.MVP.BasedPresenter;
import com.example.panagiotis.m_events.MVP.BasedView;

/**
 * Created by Panagiotis on 23/12/2016.
 */

public interface IContract_Facebook {

    public interface IPresenter_Facebook extends BasedPresenter {
        void getUserProfile();
    }

    public interface IView_Facebook extends BasedView<IContract_Facebook.IPresenter_Facebook> {

        void displayProfile();
    }
}
