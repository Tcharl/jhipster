package io.github.jhipster.service.demo;

/*-
 * #%L
 * JHipster server-side framework
 * %%
 * Copyright (C) 2016 - 2018 JHipster
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

import org.springframework.data.jpa.domain.Specification;

import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.LongFilter;

/**
 * This class is just a compile - test.
 *
 */
public class ChildEntityQueryService extends QueryService<ChildEntity> {

    static class ChildEntityCriteria extends BaseEntityQueryService.BaseEntityCriteria {
        LongFilter parentId;
        
        public LongFilter getParentId() {
            return id;
        }
    }

    public Specification<ChildEntity> createSpecification(ChildEntityCriteria criteria) {
        Specification<ChildEntity> specification = Specification.where(null);
        if (criteria.getParentId() != null) {
            specification = specification.and(buildReferringEntitySpecification(criteria.getParentId(), ChildEntity_.parent, ParentEntity_.id)); 
        }
        return specification;
    }
    
}
