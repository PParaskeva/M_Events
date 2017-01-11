package com.example.panagiotis.m_events.getSongKickData;

import com.example.panagiotis.m_events.MVP.BasedPresenter;
import com.example.panagiotis.m_events.MVP.BasedView;
import com.example.panagiotis.m_events.pojo.eventFull_pojo.songkick.Example_songkick;

/**
 * Created by Panagiotis on 06/01/2017.
 */

public interface IContract_GetSoncKick {
    public interface IPresenter_SongKick extends BasedPresenter {

        public void getEventsNextToMe(String location);
    }

    public interface IView_SongKick extends BasedView<IContract_GetSoncKick.IPresenter_SongKick> {

        public void displayEventsNextToMe(Example_songkick example_songkick);
    }
}
