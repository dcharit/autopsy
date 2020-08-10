/*
 * Autopsy Forensic Browser
 *
 * Copyright 2020 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule.datasourcesummary;

import javax.swing.JTabbedPane;
import org.sleuthkit.autopsy.casemodule.IngestJobInfoPanel;
import org.sleuthkit.datamodel.DataSource;

/**
 * A tabbed pane showing the summary of a data source including tabs of:
 * DataSourceSummaryCountsPanel, DataSourceSummaryDetailsPanel, and
 * IngestJobInfoPanel.
 */
public class DataSourceSummaryTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    
    private final DataSourceSummaryCountsPanel countsPanel;
    private final DataSourceSummaryDetailsPanel detailsPanel;
    private final IngestJobInfoPanel ingestHistoryPanel;

    private DataSource dataSource = null;

    /**
     * Constructs a tabbed pane showing the summary of a data source.
     */
    public DataSourceSummaryTabbedPane() {
        countsPanel = new DataSourceSummaryCountsPanel();
        detailsPanel = new DataSourceSummaryDetailsPanel();
        ingestHistoryPanel = new IngestJobInfoPanel();
        
        addTab(Bundle.DataSourceSummaryDialog_detailsTab_title(), detailsPanel);
        addTab(Bundle.DataSourceSummaryDialog_countsTab_title(), countsPanel);
        addTab(Bundle.DataSourceSummaryDialog_ingestHistoryTab_title(), ingestHistoryPanel);
    }

    /**
     * The datasource currently used as the model in this panel.
     *
     * @return The datasource currently being used as the model in this panel.
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Sets datasource to visualize in the tabbed panel.
     *
     * @param dataSource The datasource to use in this panel.
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        detailsPanel.setDataSource(dataSource);
        countsPanel.setDataSource(dataSource);
        ingestHistoryPanel.setDataSource(dataSource);
    }
}
