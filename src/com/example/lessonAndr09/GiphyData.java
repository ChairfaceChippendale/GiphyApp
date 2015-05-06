package com.example.lessonAndr09;

import android.media.Image;

import java.io.Serializable;
import java.util.List;


public class GiphyData implements Serializable {


    private GiphyImeg images;
    private String type;

    public GiphyImeg getImeges() {
        return images;
    }
    public String getType() {return type; }
}


/*
{
            "type": "gif",
            "id": "DFiwMapItOTh6",
            "url": "http://giphy.com/gifs/funny-cat-DFiwMapItOTh6",
            "bitly_gif_url": "http://gph.is/1aakRc4",
            "bitly_url": "http://gph.is/1aakRc4",
            "embed_url": "http://giphy.com/embed/DFiwMapItOTh6",
            "username": "",
            "source": "http://tumblr.com",
            "rating": "g",
            "caption": "",
            "content_url": "",
            "import_datetime": "2014-02-01 10:26:38",
            "trending_datetime": "1970-01-01 00:00:00",
            "images": {
                "fixed_height": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/200.gif",
                    "width": "302",
                    "height": "200",
                    "mp4": "http://media.giphy.com/media/DFiwMapItOTh6/200.mp4"
                },
                "fixed_height_still": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/200_s.gif",
                    "width": "302",
                    "height": "200"
                },
                "fixed_height_downsampled": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/200_d.gif",
                    "width": "302",
                    "height": "200"
                },
                "fixed_width": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/200w.gif",
                    "width": "200",
                    "height": "132",
                    "mp4": "http://media.giphy.com/media/DFiwMapItOTh6/200w.mp4"
                },
                "fixed_width_still": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/200w_s.gif",
                    "width": "200",
                    "height": "132"
                },
                "fixed_width_downsampled": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/200w_d.gif",
                    "width": "200",
                    "height": "132"
                },
                "downsized": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/giphy.gif",
                    "width": "245",
                    "height": "162",
                    "size": "653626"
                },
                "downsized_still": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/giphy_s.gif",
                    "width": "245",
                    "height": "162"
                },
                "original": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/giphy.gif",
                    "width": "245",
                    "height": "162",
                    "size": "653626",
                    "frames": "54",
                    "mp4": "http://media.giphy.com/media/DFiwMapItOTh6/giphy.mp4"
                },
                "original_still": {
                    "url": "http://media4.giphy.com/media/DFiwMapItOTh6/giphy_s.gif",
                    "width": "245",
                    "height": "162"
                }
            }
        },
*/
