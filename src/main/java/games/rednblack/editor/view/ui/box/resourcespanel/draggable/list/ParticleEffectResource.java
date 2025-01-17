/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package games.rednblack.editor.view.ui.box.resourcespanel.draggable.list;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import games.rednblack.editor.HyperLap2DFacade;
import games.rednblack.editor.view.ui.box.UIResourcesBoxMediator;
import games.rednblack.h2d.common.ResourcePayloadObject;

/**
 * Created by azakhary on 7/3/2014.
 */
public class ParticleEffectResource extends ListItemResource {
    private final HyperLap2DFacade facade;
    private final Image payloadImg;
    private final ResourcePayloadObject payload;

    public ParticleEffectResource(String particleName) {
        super(particleName, "particle");
        facade = HyperLap2DFacade.getInstance();
        payloadImg = new Image(getStyle().resourceOver) {
            @Override
            public void setScale(float scaleXY) {
                //Do not scale
            }
        };
        payloadImg.setScale(2);
        payloadImg.getColor().a = .85f;
        payload = new ResourcePayloadObject();
        payload.name = particleName;
        setRightClickEvent(UIResourcesBoxMediator.PARTICLE_EFFECT_RIGHT_CLICK, payload.name);
        payload.className = getClass().getName();
    }

    @Override
    public Actor getDragActor() {
        return payloadImg;
    }

    @Override
    public ResourcePayloadObject getPayloadData() {
        return payload;
    }
}
