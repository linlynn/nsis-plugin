package jenkins.plugins.nsis;

import hudson.Extension;
import hudson.util.FormValidation;
import hudson.tasks.Builder;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import jenkins.python.expoint.BuilderPW;
import jenkins.python.descriptor.BuildStepDescriptorPW;

public class NsisBuilder extends BuilderPW {

    public final String name;

    @DataBoundConstructor
    public NsisBuilder(String name) {
        this.name = name;
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptorPW<Builder> {

        public boolean french;
        
        public DescriptorImpl() {
            execPython("descriptor_impl");
        }
        
        public FormValidation doCheckName(@QueryParameter String value) {
            return (FormValidation)execPython("do_check_name", value);
        }
    }
}
