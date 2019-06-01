package com.github.Doomsdayrs.api.novelreader_core.services.core.dep;

import com.github.Doomsdayrs.api.novelreader_core.services.core.objects.Novel;
import com.github.Doomsdayrs.api.novelreader_core.services.core.objects.NovelPage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.List;


/**
 * This file is part of novelreader-core.
 * novelreader-core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with novelreader-core.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * novelreader-core
 * 29 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public abstract class ScrapeFormat implements Formatter {

    private final int ID;
    private Request.Builder builder;
    private OkHttpClient client;

    public ScrapeFormat(int id) {
        ID = id;
        this.builder = new Request.Builder();
        this.client = new OkHttpClient();
    }

    public ScrapeFormat(int id, Request.Builder builder) {
        ID = id;
        this.builder = builder;
        this.client = new OkHttpClient();
    }

    public ScrapeFormat(int id, OkHttpClient client) {
        ID = id;
        this.builder = new Request.Builder();
        this.client = client;
    }

    public ScrapeFormat(int id, Request.Builder builder, OkHttpClient client) {
        ID = id;
        this.builder = builder;
        this.client = client;
    }


    protected ResponseBody request(String url) throws IOException {
        System.out.println(url);
        URL u = new URL(url);
        Request request = builder.url(u).build();
        return client.newCall(request).execute().body();
    }

    protected Document docFromURL(String URL) throws IOException {
        return Jsoup.parse(request(URL).string());
    }


    // Methods below override the formatter classes methods

    public int getID(){
        return ID;
    }

    public abstract String getImageURL();

    public abstract boolean isIncrementingChapterList();

    public abstract String getNovelPassage(String URL) throws IOException;

    public abstract NovelPage parseNovel(String URL) throws IOException;

    public abstract NovelPage parseNovel(String URL, int increment) throws IOException;

    public abstract String getLatestURL(int page);

    public abstract List<Novel> parseLatest(String URL) throws IOException;

    public abstract List<Novel> search(String query) throws IOException;
}
