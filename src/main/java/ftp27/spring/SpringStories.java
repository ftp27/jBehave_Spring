package ftp27.spring;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;

import java.util.List;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure()
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@UsingSpring(resources = {"/configuration.xml"})
@UsingSteps
public class SpringStories extends InjectableEmbedder {


    @Test
    public void run() {
        injectedEmbedder().useCandidateSteps(stepsFactory().createCandidateSteps());
        injectedEmbedder().runStoriesAsPaths(storyPaths());

    }

    private ApplicationContext createContext() {
        return new SpringApplicationContextFactory("/steps.xml")
                .createApplicationContext();
    }

    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(injectedEmbedder().configuration(), createContext());
    }


    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
    }

}
