package ftp27.spring;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingPaths;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

//@RunWith(SpringAnnotatedEmbedderRunner.class)
//@Configure()
//@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
//@UsingSpring(resources = {"/configuration.xml", "/steps.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/steps.xml" })
public class SpringStories{          //

    @Autowired
    protected ApplicationContext context;

    private Embedder embedder;

    @Before
    public void setup() {
        embedder = new CoreEmbedder();
        embedder.useCandidateSteps(new SpringStepsFactory(embedder.configuration(), context).createCandidateSteps());
    }

    @Test
    public void runStoriesAsPaths() {
        List<String> storyPaths = storyPaths();
        embedder.runStoriesAsPaths(storyPaths);
    }

    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
    }

}
