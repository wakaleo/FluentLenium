/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package fr.javafreelance.integration;

import fr.javafreelance.integration.localTest.LocalFluentCase;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ActionOnSelectorWithBddTest extends LocalFluentCase {
    @Test
    public void checkFillAction() {
        goTo(DEFAULT_URL);
        assertThat(findFirst("#name").getValue()).contains("John");
        fill(findFirst("#name")).with("zzz");
        assertThat(findFirst("#name").getValue()).isEqualTo("zzz");
    }

    @Test
    public void checkClearAction() {
        goTo(DEFAULT_URL);
        assertThat(findFirst("#name").getValue()).contains("John");
        clear(findFirst("#name"));
        assertThat($("#name").first().getValue()).isEqualTo("");
    }

    @Test
    public void checkClickAction() {
        goTo(DEFAULT_URL);
        assertThat(title()).contains("Selenium");
        click(findFirst("#linkToPage2"));
        assertThat(title()).isEqualTo("Page 2");
    }
}
