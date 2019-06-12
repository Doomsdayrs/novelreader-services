package com.github.Doomsdayrs.api.novelreader_core.services.core.dep;

import com.github.Doomsdayrs.api.novelreader_core.services.core.objects.Novel;
import com.github.Doomsdayrs.api.novelreader_core.services.core.objects.NovelGenre;
import com.github.Doomsdayrs.api.novelreader_core.services.core.objects.NovelPage;

import java.io.IOException;
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
 * 30 / May / 2019
 *
 * @author github.com/doomsdayrs
 * @noinspection unused
 */
public interface Formatter {

    /**
     * @return Name of the class
     */
    String getName();

    /**
     * @return Image URL of the parser, yes it can be custom
     */
    String getImageURL();

    /**
     * Set int ID as param in constructor and pass it up to the ScrapeFormat
     *
     * @return Formatter ID
     */
    int getID();

    /**
     * @return Has Search?
     */
    boolean hasSearch();

    /**
     * @return Has Genres?
     */
    boolean hasGenres();

    /**
     * Returns true if the chapter list on the page requires another reload
     *
     * @return true if the above matches
     */
    boolean isIncrementingChapterList();

    /**
     * Parse the novel Chapter
     *
     * @param URL Incoming Novel chapter URL to parse
     * @return The Passage of the novel
     */
    String getNovelPassage(String URL) throws IOException;

    /**
     * Parse the novelPage
     *
     * @param URL Incoming Novel page URL to parse
     * @return NovelPage object with as many parameters filled as possible;
     */
    NovelPage parseNovel(String URL) throws IOException;

    /**
     * the above, except if isIncrementingChapterList() returns true this will be used in its stead
     *
     * @param URL       Incoming Novel page URL to parse
     * @param increment What increment to use
     * @return NovelPage of parsed chapters
     * @throws IOException If any error occurs
     */
    NovelPage parseNovel(String URL, int increment) throws IOException;

    /**
     * If there is a latest page, use this to return a certain page. Starts at 1 onwards
     *
     * @param page page number
     * @return string URL of the next latest page
     */
    String getLatestURL(int page);

    /**
     * @param URL LatestPage URL to be parsed for novels
     * @return List of novels listed
     */
    List<Novel> parseLatest(String URL) throws IOException;

    /**
     * @param query query string to be searched for
     * @return List of novels listed
     */
    List<Novel> search(String query) throws IOException;

    /**
     * ArrayList of genres site has
     * @return genres
     */
    NovelGenre[] getGenres();
}
