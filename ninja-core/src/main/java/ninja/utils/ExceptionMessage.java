/*
 * Copyright (C) 2012-2015 the original author or authors.
 *
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
 */

package ninja.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * A pojo to be rendered as Json or Xml.
 * Used for instance to display error messages when a route is not found.
 */
public  class ExceptionMessage extends Message {
    
    public ExceptionMessage(Exception exception) {
        StringWriter sw = new StringWriter();
        sw.append("Unhandled Exception: ");
        sw.append(exception.getMessage());
        sw.append("\r\n\r\n");
        try(PrintWriter ew = new PrintWriter(sw))
        {
            exception.printStackTrace(ew);
        }
        text = sw.toString();
    }
}