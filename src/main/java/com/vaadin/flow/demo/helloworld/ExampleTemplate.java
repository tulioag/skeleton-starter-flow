/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.demo.helloworld;

import com.vaadin.flow.demo.helloworld.ExampleTemplate.ExampleModel;
import com.vaadin.flow.model.TemplateModel;
import com.vaadin.ui.Tag;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.combobox.ComboBox;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.polymertemplate.Id;
import com.vaadin.ui.polymertemplate.PolymerTemplate;

/**
 * Simple template example.
 */
@Tag("example-template")
@HtmlImport("ExampleTemplate.html")
public class ExampleTemplate extends PolymerTemplate<ExampleModel> {

	@Id("combo1")
	private ComboBox<String> combo1;

	@Id("button1")
	private Button button;
	/**
	 * Template model which defines the single "value" property.
	 */
	public interface ExampleModel extends TemplateModel {

		void setValue(String value);
	}

	public ExampleTemplate() {
		// Set the initial value to the "value" property.
		getModel().setValue("Not clicked");
		combo1.setItems("item 1", "item 2", "item 3");
		combo1.setValue("item 2");
		button.addClickListener(e -> {
			combo1.setValue(combo1.getValue());
		});
		// This works.
		// combo1.getElement().setAttribute("value", "item 2");
	}

	public void setValue(String value) {
		getModel().setValue(value);
	}
}
