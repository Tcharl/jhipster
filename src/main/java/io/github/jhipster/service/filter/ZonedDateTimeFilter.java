package io.github.jhipster.service.filter;

/*
 * #%L
 * JHipster core library
 * %%
 * Copyright (C) 2013 - 2017 jhipster
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Filter class for {@link ZonedDateTime} type attributes.
 */
public class ZonedDateTimeFilter extends RangeFilter<ZonedDateTime> {

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setEquals(ZonedDateTime equals) {
        super.setEquals(equals);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setGreaterThan(ZonedDateTime equals) {
        super.setGreaterThan(equals);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setGreaterOrEqualThan(ZonedDateTime equals) {
        super.setGreaterOrEqualThan(equals);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setLessThan(ZonedDateTime equals) {
        super.setLessThan(equals);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setLessOrEqualThan(ZonedDateTime equals) {
        super.setLessOrEqualThan(equals);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setIn(List<ZonedDateTime> in) {
        super.setIn(in);
    }
}
