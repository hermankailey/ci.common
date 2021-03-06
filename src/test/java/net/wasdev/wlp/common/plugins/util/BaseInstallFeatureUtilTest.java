/**
 * (C) Copyright IBM Corporation 2018.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wasdev.wlp.common.plugins.util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class BaseInstallFeatureUtilTest {

    private static final String RESOURCES_INSTALL_DIR = "src/test/resources/installdir";
    
    public File installDir;
    
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Before
    public void setupInstallDir() throws IOException {
        installDir = temp.newFolder();
        File src = new File(RESOURCES_INSTALL_DIR);
        FileUtils.copyDirectory(src, installDir);
    }
    
    public class InstallFeatureTestUtil extends InstallFeatureUtil {
        public InstallFeatureTestUtil(File installDirectory, String from, String to, Set<String> pluginListedEsas)  throws PluginScenarioException, PluginExecutionException {
            super(installDirectory, from, to, pluginListedEsas);
        }

        @Override
        public void debug(String msg) {
            // not needed for tests
        }

        @Override
        public void debug(String msg, Throwable e) {
            // not needed for tests
        }

        @Override
        public void debug(Throwable e) {
            // not needed for tests
        }

        @Override
        public void warn(String msg) {
            // not needed for tests
        }

        @Override
        public void info(String msg) {
            // not needed for tests
        }

        @Override
        public boolean isDebugEnabled() {
            return false;
        }
        
        @Override
        public File downloadArtifact(String groupId, String artifactId, String type, String version) throws PluginExecutionException {
            return new File("dummy");
        }
    }
    
    public InstallFeatureUtil getNewInstallFeatureUtil() throws PluginExecutionException, PluginScenarioException {
        return new InstallFeatureTestUtil(installDir, null, null, new HashSet<String>());
    }
    
}
