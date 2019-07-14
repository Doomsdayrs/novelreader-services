package com.github.Doomsdayrs.api.novelreader_core.services.core.objects;

import java.io.Serializable;

/*
 * This file is part of novelreader-core.
 * novelreader-core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * novelreader-core is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with novelreader-core.  If not, see https://www.gnu.org/licenses/.
 * ====================================================================
 * novelreader-core
 * 29 / May / 2019
 *
 * @author github.com/doomsdayrs
 * @noinspection WeakerAccess
 */
public class NovelChapter implements Serializable {
    public String release = "";
    public String chapterNum = "";
    public String link = "";

    @Override
    public String toString() {
        return "NovelChapter{" +
                "release='" + release + '\'' +
                ", chapterNum=" + chapterNum +
                ", link='" + link + '\'' +
                '}';
    }
}
